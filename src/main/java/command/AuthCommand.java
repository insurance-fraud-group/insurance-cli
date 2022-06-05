package command;

import command.menu.AuthMenu;
import command.menu.MainMenu;
import command.parser.AuthParser;
import domain.Employee;
import domain.enums.EmployeeType;
import java.util.Arrays;
import service.impl.AuthServiceImpl;
import utils.Session;

public class AuthCommand extends Command {

  private static final AuthParser parser = AuthParser.getInstance();
  private static final AuthServiceImpl authService = new AuthServiceImpl();

  public static void run() {
    printMenu("사용자 인증", AuthMenu.values());
    initialize();
  }

  public static void signIn() {
    printTitle("로그인");
    Employee request = Employee.builder()
        .email(parser.getEmail())
        .password(parser.getPassword())
        .build();
    Session.getSession().register(authService.signIn(request));
  }

  public static void signUp() {
    printTitle("회원가입");
    Employee request = Employee.builder()
        .email(parser.getEmail())
        .password(parser.getPassword())
        .name(parser.getName())
        .employeeType(parser.getEmployeeType())
        .build();
    Session.getSession().register(authService.signUp(request));
  }

  public static void initialize() {
    if (!Session.getSession().isExist()) {
      System.out.println("프로그램을 종료합니다.");
      System.exit(0);
    }

    Arrays.stream(MainMenu.values()).forEach(command -> {
      EmployeeType employeeType = Session.getSession().getUser().getEmployeeType();
      if (employeeType.name().equals(command.name())) {
        command.execute();
      }
    });
  }
}
