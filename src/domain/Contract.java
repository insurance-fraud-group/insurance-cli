package domain;

import domain.product.Product;
import dto.ContractServiceDto;
import java.io.File;

public class Contract {

  private int id;
  private boolean completion;
  private Customer customer;
  private Product product;
  private File subscription;

  public Contract(ContractServiceDto dto) {
    this.id = dto.getId();
    this.completion = dto.isCompletion();
    this.customer = dto.getCustomer();
    this.product = dto.getProduct();
    this.subscription = dto.getSubscription();
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public boolean isCompletion() {
    return completion;
  }

  public void setCompletion(boolean completion) {
    this.completion = completion;
  }

  public Customer getCustomer() {
    return customer;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  public File getSubscription() {
    return subscription;
  }

  public void setSubscription(File subscription) {
    this.subscription = subscription;
  }

  public void update(ContractServiceDto dto) {
    this.completion = dto.isCompletion();
    this.customer = dto.getCustomer();
    this.product = dto.getProduct();
    this.subscription = dto.getSubscription();
  }
}
