package com.insurancefraudgroup.insurancesystem.service;

import com.insurancefraudgroup.insurancesystem.domain.product.Product;

public interface ProductService {

  void create(Product product);

  void delete(String productCode);

  Product read(String productCode);

  void update(Product product);
}
