package command.parser;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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

  public String getAddress() {
    System.out.print("주소 : ");
    return sc.next();
  }

  public String getJob() {
    System.out.print("직업 : ");
    return sc.next();
  }

  public String getAccountNumber() {
    System.out.print("계좌번호 : ");
    return sc.next();
  }

  public String getPhoneNumber() {
    System.out.print("전화번호 : ");
    return sc.next();
  }

  public boolean getSex() {
    System.out.print("성별 : ");
    return sc.nextBoolean();
  }

  public LocalDate getBirth() {
    System.out.print("생년월일(yyyy-mm-dd): ");
    return LocalDate.parse(sc.next(), DateTimeFormatter.ISO_DATE);
  }
}
