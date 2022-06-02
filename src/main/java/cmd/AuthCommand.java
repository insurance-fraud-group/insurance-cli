package cmd;

import cmd.menu.AuthMenu;
import cmd.parser.AuthParser;
import cmd.parser.Parser;
import dto.AuthDto;
import java.util.Arrays;
import service.impl.AuthServiceImpl;
import utils.Session;

public class AuthCommand {

  private static final AuthParser parser = AuthParser.getInstance();
  private static final AuthServiceImpl authService = new AuthServiceImpl();

  public static void run() {
    System.out.println("[Auth]");

    Arrays.stream(AuthMenu.values()).forEach(menu -> {
      System.out.println(
          Integer.toString(menu.ordinal() + 1)
              .concat(". ")
              .concat(menu.toString()));
    });

    System.out.print("> ");
    int selectedMenu = Parser.getScanner().nextInt();

    Arrays.stream(AuthMenu.values()).forEach(menu -> {
      if (selectedMenu == menu.ordinal() + 1) {
        menu.execute();
      }
    });
  }

  public static void signin() {
    System.out.println("\n[Sign In]");
    AuthDto.SigninRequest request = AuthDto.SigninRequest.builder()
        .email(parser.getEmail())
        .password(parser.getPassword())
        .build();
    AuthDto.SigninResponse response = authService.signin(request);
    Session.getInstance().setName(response.getName());
    Session.getInstance().setEmployeeType(response.getEmployeeType());
  }

  public static void signup() {
    System.out.println("\n[Sign Up]");
    AuthDto.SignupRequest request = AuthDto.SignupRequest.builder()
        .email(parser.getEmail())
        .password(parser.getPassword())
        .name(parser.getName())
        .employeeType(parser.getEmployeeType())
        .build();
    AuthDto.SignupResponse response = authService.signup(request);
    Session.getInstance().setName(response.getName());
    Session.getInstance().setEmployeeType(response.getEmployeeType());
  }
}
