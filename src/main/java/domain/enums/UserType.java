package domain.enums;

public enum UserType {
  ACCIDENT_INVESTIGATOR("사고조사자"),
  ADJUSTER("손해사정사"),
  COUNSELOR("상담사"),
  ACTUARY("보험계리사"),
  SALES("영업부"),
  UNDERWRITER("언더라이터");

  private final String label;

  UserType(String label) {
    this.label = label;
  }

  @Override
  public String toString() {
    return this.label;
  }
}
