package command;

import domain.enums.EmployeeType;
import java.util.Arrays;

public class AuthCommand extends Command {

  private static class InstanceHolder {

    private static final AuthCommand INSTANCE = new AuthCommand();
  }

  private AuthCommand() {
    super();
  }

  public static AuthCommand getInstance() {
    return InstanceHolder.INSTANCE;
  }

  @Override
  public void initialize() {
    System.out.println("Auth");
  }

  public String getEmployeeType() {
    System.out.println("Employee Type");
    Arrays.stream(EmployeeType.values()).forEach(type -> {
      System.out.println(
          Integer.toString(type.ordinal() + 1)
              .concat(". ")
              .concat(type.name()));
    });

    System.out.print("Enter Employee Type : ");
    while (!sc.hasNextInt()) {
      sc.next();
      System.out.println("Please enter a number within the range.");
    }

    int employeeType = sc.nextInt();
    return (employeeType < 1 || employeeType > EmployeeType.values().length) ? getEmployeeType()
        : EmployeeType.values()[employeeType - 1].name();
  }

  public String getEmail() {
    System.out.print("Enter Email : ");
    return sc.nextLine();
  }

  public String getPassword() {
    System.out.print("Enter Password : ");
    return sc.nextLine();
  }

  public String getName() {
    System.out.print("Enter Name : ");
    return sc.nextLine();
  }
}
