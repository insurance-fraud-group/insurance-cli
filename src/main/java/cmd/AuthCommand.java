package cmd;

import cmd.parser.AuthParser;
import dto.AuthDto;
import service.impl.AuthServiceImpl;

public class AuthCommand {

  private static final AuthServiceImpl authService = new AuthServiceImpl();
  private static final AuthParser parser = AuthParser.getInstance();

  private AuthCommand() {
    super();
  }

  public static void signup() {
    AuthDto.SignupRequest request = AuthDto.SignupRequest.builder()
        .email(parser.getEmail())
        .password(parser.getPassword())
        .name(parser.getName())
        .employeeType(parser.getEmployeeType())
        .build();
    authService.signup(request);
  }
}
