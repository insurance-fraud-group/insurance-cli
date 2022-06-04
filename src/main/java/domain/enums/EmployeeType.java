package domain.enums;

public enum EmployeeType {
  ACCIDENT_INVESTIGATOR("사고조사자"),
  ADJUSTER("손해사정사"),
  CUSTOMER_SERVICE_AGENT("고객서비스 담당자"),
  ACTUARY("보험계리사"),
  SALES("영업부"),
  UNDERWRITER("언더라이터");

  private final String label;

  EmployeeType(String label){
    this.label = label;
  }

  @Override
  public String toString(){return this.label;}
}
