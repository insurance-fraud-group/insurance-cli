package utils;

import domain.enums.EmployeeType;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Session {

  private static class SessionHolder {

    private static final Session INSTANCE = new Session();
  }

  public static Session getInstance() {
    return SessionHolder.INSTANCE;
  }

  private String name;

  @Enumerated(EnumType.STRING)
  private EmployeeType employeeType;
}
