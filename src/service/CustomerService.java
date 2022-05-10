package service;

import domain.Customer;

public interface CustomerService {

  void create(Customer customer);

  void delete(int id);

  Customer read(int id);

  void update(Customer customer);
}
