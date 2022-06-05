package command.menu.underwriting;


import command.UnderwritingCmd;
import command.menu.Menu;
import domain.Underwriting;
import java.util.function.Consumer;

public enum UWManagement implements Menu {
  Progress("인수 진행", (underwriting) -> UnderwritingCmd.progressUnderwrite(underwriting)),
  Collaboration("공동인수 진행", (underwriting) -> UnderwritingCmd.manageCollaboration(underwriting)),
  Reinsurance("재보험 진행", (underwriting) -> UnderwritingCmd.manageReinsurance(underwriting));

  private final String label;
  private final Consumer<Underwriting> operator;

  UWManagement(String label, Consumer<Underwriting> operator) {
    this.label = label;
    this.operator = operator;
  }

  public void execute(Underwriting underwriting) {
    operator.accept(underwriting);
  }

  @Override
  public void execute() {

  }

  @Override
  public String toString() {
    return this.label;
  }
}
