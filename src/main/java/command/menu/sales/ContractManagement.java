package command.menu.sales;

import command.SalesCmd;
import command.menu.Menu;

public enum ContractManagement implements Menu {

  ContractSearchAll("모든 계약 조회", SalesCmd::searchAllContract),
  ContractSearchUnsigned("미체결 계약 조회", SalesCmd::searchUnsignedContract),
  ContractCreation("계약 생성", SalesCmd::makeContract);

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
