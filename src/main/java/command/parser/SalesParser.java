package command.parser;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class SalesParser extends Parser {

  private static class InstanceHolder {

    private static final SalesParser INSTANCE = new SalesParser();
  }

  private SalesParser() {
    super();
  }

  public static SalesParser getInstance() {
    return SalesParser.InstanceHolder.INSTANCE;
  }

  @Override
  public void initialize() {
    System.out.println("Sales");
  }

  public String getAccountNumber() {
    System.out.print("계좌번호: ");
    return sc.next();
  }

  public String getAddress() {
    System.out.print("주소: ");
    return sc.next();
  }

  public LocalDate getBirth() {
    System.out.print("생년월일(yyyy-mm-dd): ");
    return LocalDate.parse(sc.next(), DateTimeFormatter.ISO_DATE);
  }

  public String getJob() {
    System.out.print("직업: ");
    return sc.next();
  }

  public String getName() {
    System.out.print("이름: ");
    return sc.next();
  }

  public String getPhoneNumber() {
    System.out.print("전화번호: ");
    return sc.next();
  }

  public boolean getSex() {
    System.out.print("성별(1. 남성 2. 여성): ");
    return sc.nextInt() == 1;
  }

}
