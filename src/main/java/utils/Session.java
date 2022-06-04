package utils;

import domain.Employee;
import lombok.Getter;

@Getter
public class Session {

  private static class SessionHolder {

    private static final Session INSTANCE = new Session();
  }

  public static Session getSession() {
    return SessionHolder.INSTANCE;
  }

  private Employee employee = null;

  public void register(Employee employee) {
    this.employee = employee;
    System.out.println(String.format("\n%s님 환영합니다!", employee.getName()));
  }

  public boolean isExist() {
    return employee != null;
  }
}
