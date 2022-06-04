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

}
