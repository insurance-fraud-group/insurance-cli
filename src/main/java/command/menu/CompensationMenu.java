package command.menu;

import command.CompensationCommand;

public enum CompensationMenu {
  ACCIDENTCONSULTING("사고 접수 상담", CompensationCommand::consultAccident);

  private final String label;
  private final Runnable runnable;

  CompensationMenu(String label, Runnable runnable) {
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
