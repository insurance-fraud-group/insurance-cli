package command;

import command.menu.AuthMenu;
import command.parser.AuthParser;
import domain.User;
import service.impl.AuthServiceImpl;
import utils.Session;

public class AuthCmd extends Command {

  private static final AuthParser parser = AuthParser.getInstance();
  private static final AuthServiceImpl authService = new AuthServiceImpl();

  public static void run() {
    printTitle("사용자 인증");
    executeCommand(AuthMenu.values());
    goHome();
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
        .userType(parser.getUserType())
        .build();
    Session.getSession().register(authService.signUp(request));
  }
}
