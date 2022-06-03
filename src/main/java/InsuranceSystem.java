import command.AuthCommand;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.Session;

public class InsuranceSystem {

  public static void main(String[] args) {
    Logger log = Logger.getLogger("org.hibernate");
    log.setLevel(Level.OFF);

    AuthCommand.run();

    System.out.println(String.format("\n%s님 환영합니다!", Session.getInstance().getName()));
  }
}
