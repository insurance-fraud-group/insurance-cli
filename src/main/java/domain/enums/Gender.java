package domain.enums;

public enum Gender {
  MALE("남성"),
  FEMALE("여성");

  private final String label;

  Gender(String label) {
    this.label = label;
  }

  @Override
  public String toString() {
    return this.label;
  }
}
