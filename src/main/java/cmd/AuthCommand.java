package cmd;

public class AuthCommand {

  private static class InstanceHolder {

    private static final AuthCommand INSTANCE = new AuthCommand();
  }

  private AuthCommand() {
    super();
  }

  public static AuthCommand getInstance() {
    return AuthCommand.InstanceHolder.INSTANCE;
  }

  public void run() {

  }
}
