package command.menu;


import command.AccidentInvestigatorCmd;

public enum AccidentInvestigatorMenu implements Menu {

  ACCIDENTDISPATCHRECEIPT("사고 현장 출동 접수", AccidentInvestigatorCmd::receiveAccidentDispatch),
  ACCIDENTPROCESSING("사고 현장 처리", AccidentInvestigatorCmd::processAccident);

  private final String label;
  private final Runnable runnable;

  AccidentInvestigatorMenu(String label, Runnable runnable) {
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
