package domain.enums;

public enum InsuranceType {
  AUTOMOBILE_Insurance("자동차보험"),
  DRIVER_Insurance("운전자보험"),
  FIRE_Insurance("화재보험"),
  TRAVEL_Insurance("여행자보험");

  private final String label;

  InsuranceType(String label){
    this.label = label;
  }

  @Override
  public String toString(){return this.label;}
}
