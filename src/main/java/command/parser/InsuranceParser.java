package command.parser;

import domain.enums.EmployeeType;
import domain.enums.InsuranceType;
import domain.enums.Treaty;
import java.util.Arrays;

public class InsuranceParser extends Parser {


  private static class InstanceHolder {

    private static final InsuranceParser INSTANCE = new InsuranceParser();
  }

  private InsuranceParser() {
    super();
  }

  public static InsuranceParser getInstance() {
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

  public String getName() {
    System.out.print("상품명 : ");
    return sc.next();
  }

  public String getCoverDescription() {
    System.out.print("보장내용 : ");
    return sc.next();
  }

  public int getInterestRate() {
    System.out.print("요율 : ");
    return sc.nextInt();
  }

  public int getEntryAge() {
    System.out.print("가입가능 연령 : ");
    return sc.nextInt();
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
