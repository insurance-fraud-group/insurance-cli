package command;

import command.menu.AuthMenu;
import command.menu.SignInMenu;
import command.parser.AuthParser;
import domain.User;
import domain.enums.UserType;
import java.util.Arrays;
import service.impl.AuthServiceImpl;
import utils.Session;

public class AuthCmd extends Command {

  private static final AuthParser parser = AuthParser.getInstance();
  private static final AuthServiceImpl authService = new AuthServiceImpl();

  public static void run() {
    printTitle("사용자 인증");
    executeCommand(AuthMenu.values());
    initialize();
  }

  public static void signIn() {
    printTitle("로그인");
    User request = User.builder()
        .email(parser.getEmail())
        .password(parser.getPassword())
        .build();
    Session.getSession().register(authService.signIn(request));
  }

  public static void signUp() {
    printTitle("회원가입");
    User request = User.builder()
        .email(parser.getEmail())
        .password(parser.getPassword())
        .name(parser.getName())
        .userType(parser.getEmployeeType())
        .build();
    Session.getSession().register(authService.signUp(request));
  }

  public static void initialize() {
    if (!Session.getSession().isExist()) {
      System.out.println("프로그램을 종료합니다.");
      System.exit(0);
    }

    Arrays.stream(SignInMenu.values()).forEach(command -> {
      UserType userType = Session.getSession().getUser().getUserType();
      if (userType.name().equals(command.name())) {
        command.execute();
      }
    });
  }

  public static void exit() {
    Session.getSession().exit();
    AuthCmd.run();
  }
}
