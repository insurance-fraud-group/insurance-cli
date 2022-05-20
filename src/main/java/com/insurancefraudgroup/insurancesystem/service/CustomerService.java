package com.insurancefraudgroup.insurancesystem.service;

import com.insurancefraudgroup.insurancesystem.domain.Customer;
import com.insurancefraudgroup.insurancesystem.dto.CustomerServiceDto;

public interface CustomerService {

  void create(CustomerServiceDto dto);

  void delete(int id);

  Customer read(int id);

  void update(CustomerServiceDto dto);
}
