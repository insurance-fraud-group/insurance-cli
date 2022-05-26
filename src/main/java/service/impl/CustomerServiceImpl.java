package service.impl;

import domain.Customer;
import java.util.ArrayList;
import java.util.List;
import service.CustomerService;

public class CustomerServiceImpl implements CustomerService {

  private final List<Customer> customerList;

  public CustomerServiceImpl() {
    customerList = new ArrayList<>();
  }

}
