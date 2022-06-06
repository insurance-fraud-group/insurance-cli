package command;

import command.menu.CounselorMenu;
import command.menu.YesOrNoMenu;
import command.parser.AccidentParser;
import command.parser.CounselorParser;
import domain.Accident;
import domain.Contract;
import domain.Customer;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import service.impl.CounselorServiceImpl;

public class CounselorCmd extends Command {

  private static final CounselorParser counselorParser = CounselorParser.getInstance();
  private static final AccidentParser accidentParser = AccidentParser.getInstance();
  private static final CounselorServiceImpl counselorService = new CounselorServiceImpl();

  public static void run() {
    printTitle("상담");
    executeCommand(CounselorMenu.values());
  }

  public static void counsel() {
    printTitle("사고 접수 상담");
    System.out.println("피상담자의 정보를 입력해주세요");

    List<Customer> customersList = counselorService.getCustomerList();

    Customer interviewee = Customer.builder().name(counselorParser.getName())
        .birth(counselorParser.getBirth()).build();

    System.out.println("일치하는 정보는 다음과 같습니다.");
    List<Customer> filteredList = customersList.stream()
        .filter(customer -> customer.getName().equals(interviewee.getName()))
        .filter(customer -> customer.getBirth().equals(interviewee.getBirth()))
        .collect(Collectors.toList());
    printTable(filteredList);
  }

  public static void receiveAccident() {
    printTitle("사고 접수");
    System.out.println("피상담자를 선택해주세요");
    List<Customer> customerList = counselorService.getCustomerList();
    printTable(customerList);
    Customer interviewee = customerList.get(input());

    if (interviewee == null) {
      System.out.println("피상담자의 정보가 없습니다.");
    } else {
      System.out.println("사고 접수할 계약을 선택해주세요");
      List<Contract> contractList = counselorService.getContractList(interviewee);
      printTable(contractList);
      Contract contract = contractList.get(input());

      if(selectCommand(YesOrNoMenu.values()) == 0) {
        Optional.ofNullable(contract).ifPresent(customer -> {
          System.out.println("사고 정보를 기입해주세요");
          Accident accident = Accident.builder().eventLocation(accidentParser.getEventLocation())
              .accidentType(accidentParser.getAccidentType()).victim(accidentParser.getVictim())
              .contract(contract).build();
          counselorService.registerAccident(accident);
        });
        System.out.println("정상적으로 접수되었습니다.");
      } else {
        System.out.println("정상적으로 취소되었습니다.");
      }
    }
    goHome();
  }
}
