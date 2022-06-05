package utils;

import command.AuthCmd;
import domain.User;
import lombok.Getter;

@Getter
public class Session {

  private static class SessionHolder {

    private static final Session INSTANCE = new Session();
  }

  public static Session getSession() {
    return SessionHolder.INSTANCE;
  }

  private User user = null;

  public void register(User user) {
    if (user == null) {
      System.out.println("로그인에 실패했습니다.");
      AuthCmd.run();
    }
    this.user = user;
    System.out.printf("\n%s님 환영합니다!%n", user.getName());
  }

  public void exit() {
    this.user = null;
    System.out.println("로그아웃 되었습니다!");
  }

  public boolean isExist() {
    return user != null;
  }
}
