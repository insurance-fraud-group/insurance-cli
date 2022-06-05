package command.menu;

import command.CounselorCmd;

public enum CounselorMenu implements Menu {

  COUNSEL("사고 접수 상담", CounselorCmd::counsel),
  ACCIDENTRECEIPT("사고 접수", CounselorCmd::receiveAccident);

  private final String label;
  private final Runnable runnable;

  CounselorMenu(String label, Runnable runnable) {
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
