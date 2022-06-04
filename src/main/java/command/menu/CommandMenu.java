package command.menu;

import command.CompensationCommand;
import command.InsuranceDesignCommand;
import command.SalesCommand;
import command.UnderwritingCommand;

public enum CommandMenu {
  ACCIDENT_INVESTIGATOR(CompensationCommand::run),
  ADJUSTER(CompensationCommand::run),
  CUSTOMER_SERVICE_AGENT(CompensationCommand::run),
  ACTUARY(InsuranceDesignCommand::run),
  SALES(SalesCommand::run),
  UNDERWRITER(UnderwritingCommand::run);

  private final Runnable runnable;

  CommandMenu(Runnable runnable) {
    this.runnable = runnable;
  }

  public void execute() {
    runnable.run();
  }
}
