package command.menu;

import command.AuthCommand;

public enum AuthMenu {

  SignIn("로그인", AuthCommand::signin),
  SignUp("회원가입", AuthCommand::signup),
  ;

  private String label;
  private Runnable runnable;

  AuthMenu(String label, Runnable runnable) {
    this.label = label;
    this.runnable = runnable;
  }

  public void execute() {
    runnable.run();
  }

  @Override
  public String toString() {
    return this.label;
  }
}
