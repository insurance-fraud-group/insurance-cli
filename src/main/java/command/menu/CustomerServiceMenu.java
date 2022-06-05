package command.menu;

public enum CustomerServiceMenu {
  ACCIDENTCONSULTING("사고 접수 상담", () -> {});

  private final String label;
  private final Runnable runnable;

  CustomerServiceMenu(String label, Runnable runnable) {
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
