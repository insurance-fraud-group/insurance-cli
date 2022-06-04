package command;

import command.menu.sales.Sales;
import command.menu.sales.SalesManagement;

public class SalesCommand extends Command {

  public static void run() {
    printMenu("영업", Sales.values());
  }

  public static void manageSales() {
    printMenu("영업 관리", SalesManagement.values());
  }

  public static void manageInsurance() {

  }

  public static void manageCustomer() {

  }

  public static void manageOrganization() {

  }

  public static void manageContract() {

  }

  public static void managePayment() {

  }
}
