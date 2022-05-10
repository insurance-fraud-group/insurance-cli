package domain;

import domain.product.Product;

public class Underwriting {

  private int id;
  private Customer customer;
  private int environmentalFactorScore;
  private int financialFactorScore;
  private int moralFactorScore;
  private int physicalFactorScore;
  private Product product;

  public Underwriting() {

  }
}
