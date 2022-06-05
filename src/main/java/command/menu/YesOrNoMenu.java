package command.menu;

public enum YesOrNoMenu implements Menu {

  YES("네"),
  NO("아니오");

  private final String label;

  YesOrNoMenu(String label) {
    this.label = label;
  }

  public void execute() {
  }

  @Override
  public String toString() {
    return this.label;
  }
}
