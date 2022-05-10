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

  public int getEnvironmentalFactorScore() {
    return environmentalFactorScore;
  }

  public void setEnvironmentalFactorScore(int environmentalFactorScore) {
    this.environmentalFactorScore = environmentalFactorScore;
  }

  public int getFinancialFactorScore() {
    return financialFactorScore;
  }

  public void setFinancialFactorScore(int financialFactorScore) {
    this.financialFactorScore = financialFactorScore;
  }

  public int getMoralFactorScore() {
    return moralFactorScore;
  }

  public void setMoralFactorScore(int moralFactorScore) {
    this.moralFactorScore = moralFactorScore;
  }

  public int getPhysicalFactorScore() {
    return physicalFactorScore;
  }

  public void setPhysicalFactorScore(int physicalFactorScore) {
    this.physicalFactorScore = physicalFactorScore;
  }

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }
}
