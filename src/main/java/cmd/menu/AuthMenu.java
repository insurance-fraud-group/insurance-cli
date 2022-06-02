package cmd.menu;

import cmd.AuthCommand;

public enum AuthMenu {

  SignIn("Sign In", AuthCommand::signin),
  SignUp("Sign Up", AuthCommand::signup),
  ;

  private String message;
  private Runnable runnable;

  AuthMenu(String message, Runnable runnable) {
    this.message = message;
    this.runnable = runnable;
  }

  public void execute() {
    runnable.run();
  }

  @Override
  public String toString() {
    return this.message;
  }
}
