package command;

import command.menu.CounselorMenu;

public class CounselorCmd extends Command {

  public static void run() {
    printTitle("상담");
    executeCommand(CounselorMenu.values());
  }

  public static void counsel() {
  }

  public static void receiveAccident() {
  }

}
