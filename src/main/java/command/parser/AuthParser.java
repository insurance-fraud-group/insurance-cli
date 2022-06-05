package command.parser;

import domain.enums.UserType;
import java.util.Arrays;
import utils.Password;

public class AuthParser extends Parser {

  private static class InstanceHolder {

    private static final AuthParser INSTANCE = new AuthParser();
  }

  private AuthParser() {
    super();
  }

  public static AuthParser getInstance() {
    return InstanceHolder.INSTANCE;
  }

  @Override
  public void initialize() {
    System.out.println("Auth");
  }

  public UserType getEmployeeType() {
    System.out.println("직군을 선택해주세요");
    Arrays.stream(UserType.values()).forEach(type -> {
      System.out.println(
          Integer.toString(type.ordinal() + 1)
              .concat(". ")
              .concat(type.toString()));
    });

    System.out.print("직군 : ");

    int userType = validateInteger();
    return (userType < 1 || userType > UserType.values().length) ? getEmployeeType()
        : UserType.values()[userType - 1];
  }

  public String getEmail() {
    System.out.print("이메일 : ");
    return sc.next();
  }

  public String getPassword() {
    System.out.print("패스워드 : ");
    return Password.encrypt(sc.next());
  }

  public String getName() {
    System.out.print("이름 : ");
    return sc.next();
  }
}
