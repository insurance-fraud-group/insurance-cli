package command.parser;

import domain.enums.EmployeeType;
import domain.enums.InsuranceType;
import domain.enums.Treaty;
import java.util.Arrays;

public class UnderwritingParser extends Parser {


  private static class InstanceHolder {

    private static final UnderwritingParser INSTANCE = new UnderwritingParser();
  }

  private UnderwritingParser() {
    super();
  }

  public static UnderwritingParser getInstance() {
    return InstanceHolder.INSTANCE;
  }

  @Override
  public void initialize() {
    System.out.println("Insurance");
  }

  public InsuranceType getInsuranceType() {
    System.out.println("보험종류를 선택해주세요");
    Arrays.stream(InsuranceType.values()).forEach(type -> {
      System.out.println(
          Integer.toString(type.ordinal() + 1)
              .concat(". ")
              .concat(type.toString()));
    });

    System.out.print("보험종류 : ");
    while (!sc.hasNextInt()) {
      sc.next();
      System.out.println("Please enter a number within the range.");
    }

    int insuranceType = sc.nextInt();
    return (insuranceType < 1 || insuranceType > EmployeeType.values().length) ? getInsuranceType()
        : InsuranceType.values()[insuranceType - 1];
  }


  public String getInsuranceCode() {
    System.out.print("상품코드 : ");
    return sc.next();
  }

  public int getPremium() {
    System.out.print("보험료 : ");
    return sc.nextInt();
  }

  public int getPremiumRate() {
    System.out.print("이율 : ");
    return sc.nextInt();
  }
}
