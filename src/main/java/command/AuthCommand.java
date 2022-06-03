package command;

import command.menu.AuthMenu;
import command.parser.AuthParser;
import domain.Employee;
import service.impl.AuthServiceImpl;
import utils.Session;

public class AuthCommand extends Command {

  private static final AuthParser parser = AuthParser.getInstance();
  private static final AuthServiceImpl authService = new AuthServiceImpl();

  public static void run() {
    print("[사용자 인증]", AuthMenu.values());
  }

  public static void signin() {
    System.out.println("\n[로그인]");
    Employee request = Employee.builder()
        .email(parser.getEmail())
        .password(parser.getPassword())
        .build();
    Employee response = authService.signin(request);
    Session.getSession().register(response.getName(), response.getEmployeeType());
  }

  public static void signup() {
    System.out.println("\n[회원가입]");
    Employee request = Employee.builder()
        .email(parser.getEmail())
        .password(parser.getPassword())
        .name(parser.getName())
        .employeeType(parser.getEmployeeType())
        .build();
    Employee response = authService.signup(request);
    Session.getSession().register(response.getName(), response.getEmployeeType());
  }
}
