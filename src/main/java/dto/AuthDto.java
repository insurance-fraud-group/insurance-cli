package dto;

import domain.enums.EmployeeType;
import lombok.Builder;
import lombok.Data;

public class AuthDto {

  @Data
  @Builder
  public static class SignupRequest {

    private EmployeeType employeeType;
    private String email;
    private String password;
    private String name;
  }

  @Data
  @Builder
  public static class SignupResponse {

    private EmployeeType employeeType;
    private String name;
  }

  @Data
  @Builder
  public static class SigninRequest {

    private String email;
    private String password;
  }

  @Data
  @Builder
  public static class SigninResponse {

    private EmployeeType employeeType;
    private String name;
  }
}
