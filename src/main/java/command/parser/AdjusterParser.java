package command.parser;

public class AdjusterParser extends Parser {


  private static class InstanceHolder {

    private static final AdjusterParser INSTANCE = new AdjusterParser();
  }

  private AdjusterParser() {
    super();
  }

  public static AdjusterParser getInstance() {
    return InstanceHolder.INSTANCE;
  }

  @Override
  public void initialize() {
    System.out.println("Accident");
  }

  public boolean getIndemnity() {
    System.out.print("부책/면책 (1/2) : ");
    return validateInteger(1, 2) == 1;
  }

  public String getBasis() {
    System.out.print("근거 : ");
    return sc.next();
  }

  public int getPayment() {
    System.out.print("금액 : ");
    return validateInteger();
  }
}
