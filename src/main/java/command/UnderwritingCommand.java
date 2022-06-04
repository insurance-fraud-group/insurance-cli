package command;

import command.menu.underwriting.UWManagement;
import command.menu.underwriting.UnderwritingMenu;
import command.parser.UnderwritingParser;
import domain.Employee;
import domain.Insurance;
import domain.Underwriting;
import domain.enums.InsuranceType;
import java.util.List;
import java.util.stream.Collectors;
import repository.UnderwritingRepository;
import service.impl.UnderwritingServiceImpl;

public class UnderwritingCommand extends Command {

  private static final UnderwritingParser underwritingParser = UnderwritingParser.getInstance();
  private static final UnderwritingServiceImpl underwritingImpl = new UnderwritingServiceImpl();
  private static final Employee employee = new Employee();


  public static void run() {
    printMenu("인수심사", UnderwritingMenu.values());
  }


  public static void searchAcceptancePolicy() {
    printTitle("인수정책 조회");
    String[] args = {"name", "description", "writer", "data"};
    List<Underwriting> underwritingList = underwritingImpl.searchAcceptancePolicy();
    String[][] data = getData(underwritingList, args);
    printTable(data);
  }

  public static void createAcceptancePolicy() {
    printTitle("인수정책 수립");
    System.out.println("인수정책을 수립해주세요");

    Underwriting input = Underwriting.builder()
        .name(underwritingParser.getName())
        .description(underwritingParser.getDescription())
        .writer(underwritingImpl.getEmployeeName(employee))
        .build();
    underwritingImpl.createAcceptancePolicy(input);
    System.out.println("인수정책 수립이 완료되었습니다");

    System.out.println("현재 수립된 인수정책 리스트");
    String[] args = {"name", "description", "writer", "date"};
    List<Underwriting> underwritingList = underwritingImpl.searchAcceptancePolicy();
    String[][] data = getData(underwritingList, args);
    printTable(data);
  }

  public static void manageLossRate() {
    printTitle("손해율 관리");
    System.out.println("현재 등록된 보험 리스트");
    List<Insurance> insuranceList = underwritingImpl.manageLossRate();
    printTable(insuranceList);

    InsuranceType insuranceType = underwritingParser.getInsuranceType();
    List<Insurance> filteredList = insuranceList.stream()
        .filter(i -> i.getInsuranceType().name().equals(insuranceType.name()))
        .collect(Collectors.toList());
    printTable(filteredList);

    System.out.println("관리할 상품을 선택해주세요");
    int selectedMenu = input();
    System.out.println("선택한 상품의 요율은 아래와 같습니다");
    System.out.println((insuranceList.get(selectedMenu).getPremiumRate()));

  }

  public static void underwrite() {

    printMenu("인수심사", UWManagement.values());
  }

  public static void manageCollaboration() {

  }

  public static void manageReinsurance() {

  }
}
