package command.menu;

import command.AccidentInvestigatorCmd;
import command.AdjusterCmd;
import command.CustomerServiceCmd;
import command.InsuranceDesignCmd;
import command.SalesCmd;
import command.UnderwritingCmd;

public enum MainMenu {
  ACCIDENT_INVESTIGATOR(AccidentInvestigatorCmd::run),
  ADJUSTER(AdjusterCmd::run),
  CUSTOMER_SERVICE_AGENT(CustomerServiceCmd::run),
  ACTUARY(InsuranceDesignCmd::run),
  SALES(SalesCmd::run),
  UNDERWRITER(UnderwritingCmd::run);

  private final Runnable runnable;

  MainMenu(Runnable runnable) {
    this.runnable = runnable;
  }

  public void execute() {
    runnable.run();
  }
}
