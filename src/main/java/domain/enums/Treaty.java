package domain.enums;

public enum Treaty {
  BLACKBOX_Treaty("블랙박스특약"),
  TRAVELDISTANCE_Treaty("주행거리특약"),

  LAWYER_Treaty("변호사선임특약"),
  CARACCIDENT_Treaty("차사고특약"),

  NATURALDISASTER_Treaty("자연재해특약"),
  WATERLEAK_Treaty("누수특약"),

  AFTEREFFECTS_Treaty("후유장애특약"),
  LOSSITEM_Treaty("분실물특약");


  private final String label;

  Treaty(String label){
    this.label = label;
  }

  @Override
  public String toString(){return this.label;}
}
