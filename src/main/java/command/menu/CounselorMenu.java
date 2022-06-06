package command.menu;

import command.CounselorCmd;

public enum CounselorMenu implements Menu {

  ACCIDENT_RECEIPT("사고 접수", CounselorCmd::receiveAccident),
  ACCIDENT_LOOKUP("사고 접수 조회", CounselorCmd::lookupAccident);

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
