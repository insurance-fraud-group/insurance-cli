package command.parser;

public class AccidentInvestigatorParser extends Parser {


  private static class InstanceHolder {

    private static final AccidentInvestigatorParser INSTANCE = new AccidentInvestigatorParser();
  }

  private AccidentInvestigatorParser() {
    super();
  }

  public static AccidentInvestigatorParser getInstance() {
    return InstanceHolder.INSTANCE;
  }

  @Override
  public void initialize() {
    System.out.println("AccidentInvestigator");
  }

  public String getAccidentDescription() {
    System.out.print("사고 시나리오 : ");
    return sc.next();
  }

  public int getDamage() {
    System.out.print("피해규모 : ");
    return sc.nextInt();
  }
}
