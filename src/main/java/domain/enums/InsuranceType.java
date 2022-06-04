package domain.enums;

public enum InsuranceType {
  AUTOMOBILE("자동차보험"),
  DRIVER("운전자보험"),
  FIRE("화재보험"),
  TRAVEL("여행자보험");

  private final String label;

  InsuranceType(String label) {
    this.label = label;
  }

  @Override
  public String toString() {
    return this.label;
  }
}
