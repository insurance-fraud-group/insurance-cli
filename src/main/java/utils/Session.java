package utils;

import domain.enums.EmployeeType;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import lombok.Getter;

@Getter
public class Session {

  private static class SessionHolder {

    private static final Session INSTANCE = new Session();
  }

  public static Session getSession() {
    return SessionHolder.INSTANCE;
  }

  private String name;

  @Enumerated(EnumType.STRING)
  private EmployeeType employeeType;

  private boolean exist = false;

  public void register(String name, EmployeeType employeeType) {
    this.name = name;
    this.employeeType = employeeType;
    this.exist = true;

    System.out.println(String.format("\n%s님 환영합니다!", this.name));
  }
}
