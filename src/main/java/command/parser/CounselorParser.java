package command.parser;

import domain.enums.AccidentType;

public class CounselorParser extends Parser {


  private static class InstanceHolder {

    private static final CounselorParser INSTANCE = new CounselorParser();
  }

  private CounselorParser() {
    super();
  }

  public static CounselorParser getInstance() {
    return InstanceHolder.INSTANCE;
  }

  @Override
  public void initialize() {
    System.out.println("Counselor");
  }

  public String getName() {
    System.out.print("성함 : ");
    return sc.next();
  }

  public String getBirth() {
    System.out.print("생년월일 : ");
    return sc.next();
  }

  public String getAccountNumber() {
    System.out.print("전화번호 : ");
    return sc.next();
  }

  public String getEventTime() {
    System.out.print("사고발생 시각 : ");
    return sc.next();
  }

  public boolean getVictim() {
    System.out.print("가해/피해 여부 : ");
    return sc.nextBoolean();
  }
}
