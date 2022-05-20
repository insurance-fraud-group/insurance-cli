package com.insurancefraudgroup.insurancesystem.service.impl;

import com.insurancefraudgroup.insurancesystem.domain.Customer;
import com.insurancefraudgroup.insurancesystem.dto.CustomerServiceDto;

import java.util.ArrayList;
import java.util.List;
import com.insurancefraudgroup.insurancesystem.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {

  private final List<Customer> customerList;

  public CustomerServiceImpl() {
    customerList = new ArrayList<>();
  }

  public void create(CustomerServiceDto dto) {
    Customer customer = new Customer(dto);
    customerList.add(customer);
  }

  public void delete(int id) {
    customerList.remove(id);
  }

  public Customer read(int id) {
    return customerList.get(id);
  }

  public void update(CustomerServiceDto dto) {
    int id = dto.getId();
    Customer customer = customerList.get(id);
    customer.update(dto);
  }
}
