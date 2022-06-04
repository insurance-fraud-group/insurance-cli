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

  private Employee user = null;

  public void register(Employee user) {
    this.user = user;
    System.out.println(String.format("\n%s님 환영합니다!", user.getName()));
  }

  public boolean isExist() {
    return user != null;
  }
}
