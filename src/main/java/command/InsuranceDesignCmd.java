package command;

import command.menu.InsuranceDesignMenu;
import command.parser.InsuranceParser;
import domain.Insurance;
import domain.enums.InsuranceType;
import java.util.List;
import service.impl.InsuranceDesignServiceImpl;

public class InsuranceDesignCmd extends Command {

  private static final InsuranceParser insuranceParser = InsuranceParser.getInstance();
  private static final InsuranceDesignServiceImpl insuranceDesignService = new InsuranceDesignServiceImpl();

  public static void run() {
    printTitle("보험 개발");
    executeCommand(InsuranceDesignMenu.values());
  }

  public static void searchInsurance() {
    printTitle("보험조회");
    List<Insurance> insuranceList = insuranceDesignService.searchInsurance();
    printTable(insuranceList);
    goHome();
  }

  public static void designInsurance() {
    printTitle("보험설계");
    InsuranceType insuranceType = insuranceParser.getInsuranceType();
    int count = insuranceDesignService.getCountByInsuranceType(insuranceType);

    Insurance insurance = Insurance.builder().insuranceType(insuranceType)
        .insuranceCode(insuranceType.name() + "-" + (count + 1)).name(insuranceParser.getName())
        .coverDescription(insuranceParser.getCoverDescription())
        .interestRate(insuranceParser.getInterestRate()).entryAge(insuranceParser.getEntryAge())
        .premium(insuranceParser.getPremium()).premiumRate(insuranceParser.getPremiumRate())
        .build();
    insuranceDesignService.designInsurance(insurance);
    System.out.println("보험설계가 완료되었습니다.");
    goHome();
  }
}
