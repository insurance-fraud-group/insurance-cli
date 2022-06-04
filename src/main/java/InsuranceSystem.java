import command.AuthCommand;
import command.menu.CommandMenu;
import domain.enums.EmployeeType;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.Session;

public class InsuranceSystem {

  public static void main(String[] args) {
    Logger log = Logger.getLogger("org.hibernate");
    log.setLevel(Level.OFF);

    AuthCommand.run();

    if (!Session.getSession().isExist()) {
      System.exit(0);
    }

    Arrays.stream(CommandMenu.values()).forEach(command -> {
      EmployeeType employeeType = Session.getSession().getUser().getEmployeeType();
      if (employeeType.name().equals(command.name())) {
        command.execute();
      }
    });
  }
}
