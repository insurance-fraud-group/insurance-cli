package command.menu.sales;

import command.SalesCommand;
import command.menu.Menu;

public enum CustomerManagement implements Menu {

  CustomerSearch("고객 조회", SalesCommand::searchCustomer),
  NewCustomer("신규 고객", SalesCommand::signUpCustomer);

  private final String label;
  private final Runnable runnable;

  CustomerManagement(String label, Runnable runnable) {
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
