package command.menu;

import command.AuthCommand;

public enum AuthMenu {

  SignIn("로그인", AuthCommand::signin),
  SignUp("회원가입", AuthCommand::signup),
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
