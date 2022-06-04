package command.menu;

import command.InsuranceDesignCommand;

public enum InsuranceDesignMenu implements Menu {

  InsuranceSearch("보험조회", InsuranceDesignCommand::searchInsurance),
  InsuranceDesign("보험설계", InsuranceDesignCommand::designInsurance),
  InsuranceApprovalRequestion("보험인가 요청", InsuranceDesignCommand::requestInsurance);

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
