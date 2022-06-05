package domain.enums;

public enum VictimType {
  ATTACKER("가해자"),
  VICTIM("피해자");

  private final String label;

  VictimType(String label) {
    this.label = label;
  }

  @Override
  public String toString() {
    return this.label;
  }
}
