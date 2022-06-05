package command.menu;

import command.AuthCmd;

public enum AuthMenu implements Menu {

  SignIn("로그인", AuthCmd::signIn),
  SignUp("회원가입", AuthCmd::signUp);

  private final String label;
  private final Runnable runnable;

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
