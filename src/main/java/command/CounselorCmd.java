package command;

import command.menu.CounselorMenu;
import command.parser.AccidentParser;
import command.parser.CounselorParser;
import domain.Accident;
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

    List<Customer> customersList = counselorService.counsel();

    Customer interviewee = Customer.builder()
        .name(counselorParser.getName())
        .birth(counselorParser.getBirth())
        .build();

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
    List<Customer> customerList = counselorService.counsel();
    printTable(customerList);
    Customer interviewee = customerList.get(input());
    Optional.ofNullable(interviewee).ifPresentOrElse(customer -> {
          System.out.println("사고 정보를 기입해주세요");
          Accident accident = Accident.builder()
              .eventLocation(accidentParser.getEventLocation())
              .accidentType(accidentParser.getAccidentType())
              .victim(accidentParser.getVictim())
              .customer(interviewee)
              .build();
          String[] args = {"customer", "eventTime", "eventLocation", "accidentType", "victim"};
          List<Accident> accidents = counselorService.receiveAccident(accident);
          System.out.println("사고 접수 리스트");
          printTable(accidents, args);
        }, () -> System.out.println("피상담자의 정보가 없습니다."));
  }
}
