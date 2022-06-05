package command.menu;

import command.AccidentInvestigatorCmd;
import command.AdjusterCmd;
import command.CounselorCmd;
import command.InsuranceDesignCmd;
import command.SalesCmd;
import command.UnderwritingCmd;

public enum MainMenu implements Menu{
  ACCIDENT_INVESTIGATOR(AccidentInvestigatorCmd::run),
  ADJUSTER(AdjusterCmd::run),
  COUNSELOR(CounselorCmd::run),
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
