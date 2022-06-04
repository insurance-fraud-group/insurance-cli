import command.AuthCommand;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InsuranceSystem {

  public static void main(String[] args) {
    Logger log = Logger.getLogger("org.hibernate");
    log.setLevel(Level.OFF);

    AuthCommand.run();
  }
}
