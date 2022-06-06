package command;

import command.menu.AdjusterMenu;

public class AdjusterCmd extends Command {

  public static void run() {
    printTitle("면/부책 관리");
    executeCommand(AdjusterMenu.values());
  }

  public static void examine() {
    printTitle("면/부책 검토");
  }

  public static void adjustDamage() {
    printTitle("손해사정");
  }
}
