package domain.enums;

public enum AuthorizeType {
  AUTHORIZE_WAITED("인가대기"),
  AUTHORIZE_REQUEST("인가요청"),
  AUTHORIZE_DENIED("인가거부"),
  AUTHORIZE_PERMITTED("인가허가");

  private final String label;

  AuthorizeType(String label) {
    this.label = label;
  }

  @Override
  public String toString() {
    return this.label;
  }
}
