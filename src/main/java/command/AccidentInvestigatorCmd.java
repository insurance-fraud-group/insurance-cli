package command;

import command.menu.CounselorMenu;

public class AccidentInvestigatorCmd extends Command {

  public static void run() {
    printTitle("사고 조사");
    executeCommand(CounselorMenu.values());
  }

  public static void receiveAccidentDispatch() {


  }

  public static void processAccident() {
  }
}
