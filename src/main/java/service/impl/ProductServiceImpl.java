package service.impl;

import domain.Insurance;

import java.util.ArrayList;
import java.util.List;
import service.ProductService;

public class ProductServiceImpl implements ProductService {

  private final List<Insurance> insuranceList;

  public ProductServiceImpl() {
    insuranceList = new ArrayList<>();
  }

}
