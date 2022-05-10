package domain;

import enums.AccidentType;
import java.awt.geom.Point2D;
import java.time.LocalDateTime;

public class Accident {

  private int id;
  private Customer customer;
  private Point2D eventLocation;
  private LocalDateTime eventTime;
  private boolean victim;
  private AccidentType accidentType;

  public Accident() {

  }
}
