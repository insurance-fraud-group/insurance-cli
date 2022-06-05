package domain.enums;

public enum AccidentType {
  CAR_ACCIDENT("교통사고"),
  FIRE_ACCIDENT("화재사고"),
  SPARK_ACCIDENT("감전사고"),
  CUT_ACCIDENT("절단사고"),
  BOOM_ACCIDENT("폭발사고");

  private final String label;

  AccidentType(String label) {
    this.label = label;
  }

  @Override
  public String toString() {
    return this.label;
  }
}
