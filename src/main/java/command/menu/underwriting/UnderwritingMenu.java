package command.menu.underwriting;


import command.UnderwritingCommand;
import command.menu.Menu;

public enum UnderwritingMenu implements Menu {
  AcceptancePolicySearch("인수정책 조회", UnderwritingCommand::searchAcceptancePolicy),
  AcceptancePolicyCreation("인수정책 수립", UnderwritingCommand::createAcceptancePolicy),
  LossRateManagement("손해율 관리", UnderwritingCommand::manageLossRate),
  Underwriting("인수심사", UnderwritingCommand::underwrite);

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
