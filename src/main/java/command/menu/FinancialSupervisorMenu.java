package command.menu;

import command.FinancialSupervisorCmd;

public enum FinancialSupervisorMenu implements Menu {

  InsurancePermission("보험 인가", FinancialSupervisorCmd::permitInsurance);

  private final String label;
  private final Runnable runnable;

  FinancialSupervisorMenu(String label, Runnable runnable) {
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
