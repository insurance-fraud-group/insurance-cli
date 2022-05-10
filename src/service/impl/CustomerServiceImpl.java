package service.impl;

import domain.Customer;
import dto.CustomerServiceDto;
import java.util.List;
import service.CustomerService;

public class CustomerServiceImpl implements CustomerService {

  private List<Customer> customerList;

  public CustomerServiceImpl() {

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
