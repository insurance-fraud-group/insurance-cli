package command.menu.underwriting;


import command.UnderwritingCmd;
import command.menu.Menu;

public enum UnderwritingMenu implements Menu {
  AcceptancePolicySearch("인수정책 조회", UnderwritingCmd::searchAcceptancePolicy),
  AcceptancePolicyCreation("인수정책 수립", UnderwritingCmd::createAcceptancePolicy),
  LossRateManagement("손해율 관리", UnderwritingCmd::manageLossRate),
  Underwriting("인수심사", UnderwritingCmd::underwrite);

  private final String label;
  private final Runnable runnable;

  UnderwritingMenu(String label, Runnable runnable) {
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
