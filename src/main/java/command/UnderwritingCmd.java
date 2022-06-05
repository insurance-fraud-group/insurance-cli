package command;

import command.menu.underwriting.UWManagement;
import command.menu.underwriting.UnderwritingMenu;
import command.parser.UnderwritingParser;
import domain.AcceptancePolicy;
import domain.Contract;
import domain.Customer;
import domain.Insurance;
import domain.Underwriting;
import java.util.List;
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
  }

  public static void underwrite() {
    printTitle("인수심사");
    System.out.println("인수심사를 진행할 항목을 선택해주세요.");
    List<Underwriting> unsignedUnderwritingList = underwritingService.searchUnsignedUnderwriting();
    printTable(unsignedUnderwritingList);

    Underwriting underwriting = unsignedUnderwritingList.get(input());
    Contract contract = underwriting.getContract();
    Customer customer = contract.getCustomer();
    Insurance insurance = contract.getInsurance();

    System.out.println("인수심사 대기 고객의 이름, 보험정보, 보험료는 다음과 같습니다.");
    System.out.println("이름: " + customer.toString());
    System.out.println("보험정보: " + insurance.getCoverDescription());
    System.out.println("보험료: " + insurance.getPremium());

    printTitle("점수 입력");
    System.out.println("신체적, 재정적, 환경적, 도덕적 요인의 점수를 1~5점 사이로 입력해주세요.");

    underwriting.setPhysicalFactorScore(underwritingParser.getPhysicalFactorScore());
    underwriting.setFinancialFactorScore(underwritingParser.getFinancialFactorScore());
    underwriting.setEnvironmentalFactorScore(underwritingParser.getEnvironmentFactorScore());
    underwriting.setMoralFactorScore(underwritingParser.getMoralFactorScore());

    System.out.println("\n인수심사가 " + (underwritingService.underwrite(underwriting) ? "승인" : "거절")
        + "되었습니다.");

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
