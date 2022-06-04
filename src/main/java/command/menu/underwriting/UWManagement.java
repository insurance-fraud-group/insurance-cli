package command.menu.underwriting;


import command.UnderwritingCommand;
import command.menu.Menu;

public enum UWManagement implements Menu {
  CollaborationManagement("공동인수 관리", UnderwritingCommand::manageCollaboration),
  ReinsuranceManagement("재보험 처리", UnderwritingCommand::manageReinsurance);

  private final String label;
  private final Runnable runnable;

  UWManagement(String label, Runnable runnable) {
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
