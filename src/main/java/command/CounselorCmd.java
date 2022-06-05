package command;

import command.menu.CounselorMenu;
import command.parser.AccidentParser;
import command.parser.CounselorParser;
import domain.Accident;
import domain.Customer;
import java.util.List;
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

    Customer customer = Customer.builder()
        .name(counselorParser.getName())
        .birth(counselorParser.getBirth())
        .phoneNumber(counselorParser.getPhoneNumber())
        .build();

    System.out.println("일치하는 정보는 다음과 같습니다.");
    List<Customer> filteredList = customersList.stream()
        .filter(c -> c.getName().equals(customer.getName()))
        .filter(c -> c.getBirth().equals(customer.getBirth()))
        .collect(Collectors.toList());
    printTable(filteredList);
  }

  public static void receiveAccident() {
    printTitle("사고 접수");
    System.out.println("피상담자를 선택해주세요");
    List<Customer> customerList = counselorService.counsel();
    printTable(customerList);
    Customer customer = customerList.get(input());

    System.out.println("사고 정보를 기입해주세요");
    Accident accident = Accident.builder()
        .eventLocation(accidentParser.getEventLocation())
        .accidentType(accidentParser.getAccidentType())
        .victim(accidentParser.getVictim())
        .customer(customer)
        .build();
    String[] args = {"customer", "eventTime", "eventLocation", "accidentType", "victim"};
    List<Accident> accidents = counselorService.receiveAccident(accident);
    printTable(accidents, args);
  }
}
