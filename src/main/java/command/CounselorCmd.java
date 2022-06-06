package command;

import command.menu.CounselorMenu;
import command.menu.YesOrNoMenu;
import command.parser.AccidentParser;
import domain.Accident;
import domain.Contract;
import domain.Customer;
import domain.enums.ProcessState;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import service.impl.CounselorServiceImpl;

public class CounselorCmd extends Command {

  private static final AccidentParser accidentParser = AccidentParser.getInstance();
  private static final CounselorServiceImpl counselorService = new CounselorServiceImpl();

  public static void run() {
    printTitle("상담");
    executeCommand(CounselorMenu.values());
  }

  public static void receiveAccident() {
    printTitle("사고 접수");
    System.out.println("피상담자를 선택해주세요.");
    List<Customer> customerList = counselorService.getCustomerList();
    printTable(customerList);
    Customer interviewee = customerList.get(input());

    if (interviewee == null) {
      System.out.println("피상담자의 정보가 없습니다.");
    } else {
      System.out.println("사고 접수할 계약을 선택해주세요.");
      List<Contract> contractList = counselorService.getContractList(interviewee);
      printTable(contractList);
      Contract contract = contractList.get(input());

      System.out.println("정말 사고 접수를 진행하시겠습니까?");
      if(selectCommand(YesOrNoMenu.values()) == 0) {
        Optional.ofNullable(contract).ifPresent(customer -> {
          System.out.println("사고 정보를 기입해주세요");
          Accident accident = Accident.builder().eventLocation(accidentParser.getEventLocation())
              .accidentType(accidentParser.getAccidentType()).victim(accidentParser.getVictim())
              .contract(contract).processState(ProcessState.REGISTERED).build();
          counselorService.registerAccident(accident);
        });
        System.out.println("정상적으로 접수되었습니다.");
      } else {
        System.out.println("정상적으로 취소되었습니다.");
      }
    }
    goHome();
  }

  public static void lookupAccident() {
    printTitle("사고 접수 조회");
    System.out.println("피상담자를 선택해주세요.");
    List<Customer> customerList = counselorService.getCustomerList();
    printTable(customerList);
    Customer interviewee = customerList.get(input());

    Optional.ofNullable(interviewee).ifPresentOrElse(customer -> {
      System.out.println("사고 접수된 계약을 선택해주세요.");
      List<Contract> contractList = counselorService.getContractList(customer);
      printTable(contractList);
      Contract contract = contractList.get(input());

      System.out.println("해당 계약으로 접수된 사고 목록를 출력합니다.");
      List<Accident> accidentList = counselorService.searchAccident();
      List<Accident> filteredAccidentList = accidentList.stream()
          .filter(accident -> accident.getContract().getId() == contract.getId())
          .collect(Collectors.toList());
      printTable(filteredAccidentList);
    }, () -> System.out.println("피상담자의 정보가 없습니다."));
    goHome();
  }
}
