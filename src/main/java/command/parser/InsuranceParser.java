package command.parser;

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
    return validateInteger();
  }

  public int getPremium() {
    System.out.print("보험료 : ");
    return validateInteger();
  }

  public int getPremiumRate() {
    System.out.print("이율 : ");
    return validateInteger();
  }
}
