package repository;

import domain.Underwriting;


public class UnderwritingRepository extends Repository<Underwriting, Integer> {

  private String insuranceCode;

  public void setInsuranceCode(String insuranceCode) {
  this.insuranceCode = insuranceCode;
  }
}
