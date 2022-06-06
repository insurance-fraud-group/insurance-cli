package domain.enums;

public enum ProcessState {
  REGISTERED("접수완료"),
  DISPATCH_READY("출동대기"),
  DISPATCH_COMPLETE("출동완료"),
  INDEMNITY("면부책 판단 완료"),
  ADJUST("손해사정 완료");

  private final String label;

  ProcessState(String label) {
    this.label = label;
  }

  @Override
  public String toString() {
    return this.label;
  }
}
