package com.insurancefraudgroup.insurancesystem.dto;

import com.insurancefraudgroup.insurancesystem.domain.Customer;
import com.insurancefraudgroup.insurancesystem.enums.AccidentType;
import java.awt.geom.Point2D;
import java.time.LocalDateTime;

public class AccidentServiceDto {

  private int id;
  private Customer customer;
  private Point2D eventLocation;
  private LocalDateTime eventTime;
  private boolean victim;
  private AccidentType accidentType;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Customer getCustomer() {
    return customer;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

  public Point2D getEventLocation() {
    return eventLocation;
  }

  public void setEventLocation(Point2D eventLocation) {
    this.eventLocation = eventLocation;
  }

  public LocalDateTime getEventTime() {
    return eventTime;
  }

  public void setEventTime(LocalDateTime eventTime) {
    this.eventTime = eventTime;
  }

  public boolean isVictim() {
    return victim;
  }

  public void setVictim(boolean victim) {
    this.victim = victim;
  }

  public AccidentType getAccidentType() {
    return accidentType;
  }

  public void setAccidentType(AccidentType accidentType) {
    this.accidentType = accidentType;
  }
}
