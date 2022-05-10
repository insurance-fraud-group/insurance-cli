package domain;

import dto.AdjustServiceDto;

public class Adjust {

  private int id;
  private Accident accident;
  private String basis;
  private boolean indemnity;
  private int payment;

  public Adjust(AdjustServiceDto dto) {
    this.id = dto.getId();
    this.accident = dto.getAccident();
    this.basis = dto.getBasis();
    this.indemnity = dto.isIndemnity();
    this.payment = dto.getPayment();
  }

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

  public void update(AdjustServiceDto dto) {
    this.accident = dto.getAccident();
    this.basis = dto.getBasis();
    this.indemnity = dto.isIndemnity();
    this.payment = dto.getPayment();
  }
}
