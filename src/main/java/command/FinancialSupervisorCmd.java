package command;

import command.menu.FinancialSupervisorMenu;
import service.FinancialSupervisorImpl;

public class FinancialSupervisorCmd extends Command {

  private static final FinancialSupervisorImpl financialSupervisorService = new FinancialSupervisorImpl();

  public static void run() {
    printTitle("금융 감독");
    executeCommand(FinancialSupervisorMenu.values());
  }

  public static void permitInsurance() {

  }
}
