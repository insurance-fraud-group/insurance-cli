package command.menu.underwriting;


import command.UnderwritingCmd;
import command.menu.Menu;

public enum UWManagement implements Menu {
  CollaborationManagement("공동인수 관리", UnderwritingCmd::manageCollaboration),
  ReinsuranceManagement("재보험 처리", UnderwritingCmd::manageReinsurance);

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
