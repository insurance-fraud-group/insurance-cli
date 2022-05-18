package service.impl;

import domain.product.Product;

import java.util.ArrayList;
import java.util.List;
import service.ProductService;

public class ProductServiceImpl implements ProductService {

  private final List<Product> productList;

  public ProductServiceImpl() {
    productList = new ArrayList<>();
  }

  public void create(Product insurance) {

  }

  public void delete(String productCode) {

  }

  public Product read(String productCode) {
    return null;
  }

  public void update(Product insurance) {

  }
}
