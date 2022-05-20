package com.insurancefraudgroup.insurancesystem.dto;

import com.insurancefraudgroup.insurancesystem.domain.Accident;

public class AdjustServiceDto {

  private int id;
  private Accident accident;
  private String basis;
  private boolean indemnity;
  private int payment;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Accident getAccident() {
    return accident;
  }

  public void setAccident(Accident accident) {
    this.accident = accident;
  }

  public String getBasis() {
    return basis;
  }

  public void setBasis(String basis) {
    this.basis = basis;
  }

  public boolean isIndemnity() {
    return indemnity;
  }

  public void setIndemnity(boolean indemnity) {
    this.indemnity = indemnity;
  }

  public int getPayment() {
    return payment;
  }

  public void setPayment(int payment) {
    this.payment = payment;
  }
}
