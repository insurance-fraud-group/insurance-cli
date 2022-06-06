package command.menu;

import command.InsuranceDesignCmd;

public enum InsuranceDesignMenu implements Menu {

  InsuranceSearch("보험조회", InsuranceDesignCmd::searchInsurance),
  InsuranceDesign("보험설계", InsuranceDesignCmd::designInsurance);

  private final String label;
  private final Runnable runnable;

  InsuranceDesignMenu(String label, Runnable runnable) {
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
