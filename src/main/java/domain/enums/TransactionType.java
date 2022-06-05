package domain.enums;

public enum TransactionType {
  DEPOSIT("입금"),
  WITHDRAW("출금");

  private final String label;

  TransactionType(String label) {
    this.label = label;
  }

  @Override
  public String toString() {
    return this.label;
  }
}
