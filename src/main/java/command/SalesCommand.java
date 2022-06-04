package command;

import command.menu.sales.Sales;
import command.menu.sales.SalesManagement;
import domain.Insurance;
import java.util.List;
import service.impl.SalesServiceImpl;

public class SalesCommand extends Command {

  private static final SalesServiceImpl salesService = new SalesServiceImpl();

  public static void run() {
    printMenu("영업", Sales.values());
  }

  public static void manageSales() {
    printMenu("영업 관리", SalesManagement.values());
  }

  public static void manageInsurance() {
    printTitle("보험 관리");
    List<Insurance> insuranceList = salesService.getInsuranceList();

    Command.printTable(insuranceList);
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
