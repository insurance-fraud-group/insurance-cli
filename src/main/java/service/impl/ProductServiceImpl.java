package service.impl;

import domain.Product;

import java.util.ArrayList;
import java.util.List;
import service.ProductService;

public class ProductServiceImpl implements ProductService {

  private final List<Product> productList;

  public ProductServiceImpl() {
    productList = new ArrayList<>();
  }

}
