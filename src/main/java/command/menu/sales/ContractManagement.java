package command.menu.sales;

import command.SalesCmd;
import command.menu.Menu;

public enum ContractManagement implements Menu {

  AllContract("모든 계약 조회", SalesCmd::searchAllContract),
  UWCompletedContract("인수심사가 완료된 계약 조회", SalesCmd::searchUWCompletedContracts),
  Creation("계약 생성", SalesCmd::makeContract);

  private final String label;
  private final Runnable runnable;

  ContractManagement(String label, Runnable runnable) {
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
