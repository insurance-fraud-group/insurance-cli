package command.menu;

import command.SalesCommand;

public enum SalesMenu implements Menu{

  SalesManagement("영업 관리", SalesCommand::manageSales),
  ContractManagement("계약 관리", SalesCommand::manageContract),
  PaymentManagement("납입금 관리", SalesCommand::managePayment),
  ;

  private String label;
  private Runnable runnable;

  SalesMenu(String label, Runnable runnable) {
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
