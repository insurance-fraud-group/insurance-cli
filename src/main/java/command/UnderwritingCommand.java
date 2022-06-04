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
    String[] args = {"name", "description", "writer", "date"};
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

    System.out.println("관리할 보험을 선택해주세요");
    int selectedMenu = input();
    System.out.println("선택한 보험의 요율은 아래와 같습니다");
    System.out.println((insuranceList.get(selectedMenu).getPremiumRate()));

  }

  public static void underwrite() {
    printTitle("인수심사");
    System.out.println("인수심사 대기 리스트");
    List<Insurance> insuranceList = underwritingImpl.getInsuranceList();
    List<Insurance> filteredList = insuranceList.stream()
        .filter(i -> i.getAuthorizeType().toString().equals("인가요청"))
        .collect(Collectors.toList());
    printTable(filteredList);

    System.out.println("인수심사할 보험을 선택해주세요");
    int selectedMenu = input();
    System.out.println("인수심사 대기 고객의 이름,보험정보, 보험료는 다음과 같습니다.");
    String name = insuranceList.get(selectedMenu).getName();
    String coverDescription = insuranceList.get(selectedMenu).getCoverDescription();
    int premium = insuranceList.get(selectedMenu).getPremium();
    Insurance insurance = insuranceList.get(selectedMenu);

    System.out.println("이름:" + name + " 보험정보:" + coverDescription + " 보험료:" + premium);
    System.out.println("신체,재정,환경,도덕적 요인 점수를 입력해주세요 (1~5점 사이)");
    Underwriting underwriting = Underwriting.builder()
        .physicalFactorScore(underwritingParser.getPhysicalFactorScore())
        .financialFactorScore(underwritingParser.getFinancialFactorScore())
        .environmentalFactorScore(underwritingParser.getEnvironmentFactorScore())
        .moralFactorScore(underwritingParser.getMoralFactorScore())
        .build();
    boolean result = underwritingImpl.underwrite(underwriting);

    if (result) {
      System.out.println("선택된 보험에 인수가 승인되었습니다.");
    } else {
      System.out.println("선택된 보험에 인수가 거절되었습니다");
    }
    underwritingImpl.updateInsuranceApproval(insurance,result);

    printMenu("인수심사", UWManagement.values());
  }

  public static void manageCollaboration() {

  }

  public static void manageReinsurance() {

  }
}
