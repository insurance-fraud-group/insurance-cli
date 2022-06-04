package command.menu.underwriting;

import command.UnderwritingCommand;
import command.menu.Menu;


  public enum UWAcceptanceManagement implements Menu {
    LossRateManagement("손해율 관리", UnderwritingCommand::manageLossRate);

    private final String label;
    private final Runnable runnable;

    UWAcceptanceManagement(String label, Runnable runnable) {
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


