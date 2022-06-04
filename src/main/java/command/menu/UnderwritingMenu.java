package command.menu;


import command.UnderwritingCommand;

public enum UnderwritingMenu implements Menu{

  AcceptancePolicyCreation("인수정책 수립", UnderwritingCommand::createAcceptancePolicy),
  LossRateManagement("손해율 관리", UnderwritingCommand::manageLossRate),
  Underwriting("인수심사", UnderwritingCommand::underwrite),
  CollaborationManagement("공동인수 관리", UnderwritingCommand::manageCollaboration),
  ReinsuranceManagement("재보험 처리", UnderwritingCommand::manageReinsurance);


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
