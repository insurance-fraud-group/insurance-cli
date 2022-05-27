package dto;

import domain.enums.EmployeeType;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import lombok.Builder;
import lombok.Data;

public class AuthDto {

  @Data
  @Builder
  public static class SignupRequest {

    private String email;
    private String password;
    private String name;

    @Enumerated(EnumType.STRING)
    private EmployeeType employeeType;
  }

  @Data
  @Builder
  public static class SignupResponse {

    private String name;

    @Enumerated(EnumType.STRING)
    private EmployeeType employeeType;
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

    private String name;

    @Enumerated(EnumType.STRING)
    private EmployeeType employeeType;
  }
}
