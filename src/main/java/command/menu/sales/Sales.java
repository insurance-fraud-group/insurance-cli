package command.menu.sales;

import command.SalesCommand;
import command.menu.Menu;

public enum Sales implements Menu {

  SalesManagement("영업 관리", SalesCommand::manageSales),
  ContractManagement("계약 관리", SalesCommand::manageContract),
  PaymentManagement("납입금 관리", SalesCommand::managePayment);

  private final String label;
  private final Runnable runnable;

  Sales(String label, Runnable runnable) {
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
