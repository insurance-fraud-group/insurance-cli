package command.parser;

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
    System.out.println("Underwriting");
  }

  public String getName() {
    System.out.print("정책명 : ");
    return sc.next();
  }

  public String getDescription() {
    System.out.print("상세 내용 : ");
    return sc.next();
  }

  public int getEnvironmentFactorScore() {
    System.out.print("환경적 요인 : ");
    return validateInteger(1, 5);
  }

  public int getFinancialFactorScore() {
    System.out.print("재정적 요인 : ");
    return validateInteger(1, 5);
  }

  public int getMoralFactorScore() {
    System.out.print("도덕적 요인 : ");
    return validateInteger(1, 5);
  }

  public int getPhysicalFactorScore() {
    System.out.print("신체적 요인 : ");
    return validateInteger(1, 5);
  }
}