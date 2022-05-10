package service;

import domain.Customer;
import dto.CustomerServiceDto;

public interface CustomerService {

  void create(CustomerServiceDto dto);

  void delete(int id);

  Customer read(int id);

  void update(CustomerServiceDto dto);
}
