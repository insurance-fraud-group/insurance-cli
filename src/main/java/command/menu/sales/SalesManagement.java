package command.menu.sales;

import command.SalesCommand;
import command.menu.Menu;

public enum SalesManagement implements Menu {

  InsuranceManagement("보험 관리", SalesCommand::manageInsurance),
  CustomerManagement("고객 관리", SalesCommand::manageCustomer),
  OrganizationManagement("조직 관리", SalesCommand::manageOrganization);

  private final String label;
  private final Runnable runnable;

  SalesManagement(String label, Runnable runnable) {
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