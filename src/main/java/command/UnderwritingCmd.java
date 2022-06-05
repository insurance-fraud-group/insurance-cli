package command;

import command.menu.underwriting.UWManagement;
import command.menu.underwriting.UnderwritingMenu;
import command.parser.UnderwritingParser;
import domain.AcceptancePolicy;
import domain.Insurance;
import domain.Underwriting;
import domain.enums.InsuranceType;
import java.util.List;
import java.util.stream.Collectors;
import service.impl.UnderwritingServiceImpl;
import utils.Session;

public class UnderwritingCmd extends Command {

  private static final UnderwritingParser underwritingParser = UnderwritingParser.getInstance();
  private static final UnderwritingServiceImpl underwritingService = new UnderwritingServiceImpl();


  public static void run() {
    printTitle("인수 심사");
    executeCommand(UnderwritingMenu.values());
  }


  public static void searchAcceptancePolicy() {
    printTitle("인수정책 조회");
    String[] args = {"name", "description", "writer", "createdDate"};
    List<AcceptancePolicy> acceptancePolicyList = underwritingService.searchAcceptancePolicy();
    printTable(acceptancePolicyList, args);
    AuthCmd.initialize();
  }

  public static void createAcceptancePolicy() {
    printTitle("인수정책 수립");
    System.out.println("인수정책을 수립해주세요");
    AcceptancePolicy input = AcceptancePolicy.builder()
        .name(underwritingParser.getName())
        .description(underwritingParser.getDescription())
        .writer(underwritingService.getEmployeeName(Session.getSession().getUser()))
        .build();
    underwritingService.createAcceptancePolicy(input);
    System.out.println("인수정책 수립이 완료되었습니다");

    System.out.println("현재 수립된 인수정책 리스트");
    String[] args = {"name", "description", "writer", "createdDate"};
    List<AcceptancePolicy> acceptancePolicyList = underwritingService.searchAcceptancePolicy();
    printTable(acceptancePolicyList, args);
    AuthCmd.initialize();
  }

  public static void manageLossRate() {
    printTitle("손해율 관리");
    System.out.println("현재 등록된 보험 리스트");
    List<Insurance> insuranceList = underwritingService.manageLossRate();
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
    AuthCmd.initialize();
  }

  public static void underwrite() {
    printTitle("인수심사");
    System.out.println("인수심사 대기 리스트");
    List<Insurance> insuranceList = underwritingService.getInsuranceList();
    List<Insurance> filteredList = insuranceList.stream()
        .filter(i -> i.getAuthorizeType().toString().equals("인가요청")).collect(Collectors.toList());
    printTable(filteredList);

    System.out.println("인수심사할 보험을 선택해주세요");
    int selectedMenu = input();
    Insurance insurance = filteredList.get(selectedMenu);

    System.out.println("인수심사 대기 고객의 이름, 보험정보, 보험료는 다음과 같습니다.");
    String name = filteredList.get(selectedMenu).getName();
    String coverDescription = filteredList.get(selectedMenu).getCoverDescription();
    int premium = filteredList.get(selectedMenu).getPremium();

    System.out.println("이름:" + name + " 보험정보:" + coverDescription + " 보험료:" + premium);
    System.out.println("신체,재정,환경,도덕적 요인 점수를 입력해주세요 (1~5점 사이)");
    Underwriting underwriting = Underwriting.builder()
        .physicalFactorScore(underwritingParser.getPhysicalFactorScore())
        .financialFactorScore(underwritingParser.getFinancialFactorScore())
        .environmentalFactorScore(underwritingParser.getEnvironmentFactorScore())
        .moralFactorScore(underwritingParser.getMoralFactorScore()).build();
    boolean result = underwritingService.underwrite(underwriting);

    if (result) {
      System.out.println("선택된 보험에 인수가 승인되었습니다.");
    } else {
      System.out.println("선택된 보험에 인수가 거절되었습니다");
    }
    underwritingService.updateInsuranceApproval(insurance, result);

    System.out.println("선택된 보험을 다른 방식으로 처리하시겠습니까?");
    printTitle("공동인수 , 재보험");
    executeCommand(UWManagement.values());
  }

  public static void manageCollaboration() {
    printTitle("공동 인수 관리");
    System.out.println("공동 인수 관리 ~~");
    AuthCmd.initialize();
  }

  public static void manageReinsurance() {
    printTitle("재보험 처리");
    System.out.println("재보험 처리 ~~");
    AuthCmd.initialize();
  }
}
