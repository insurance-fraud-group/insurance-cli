package service;

import domain.Contract;
import domain.Customer;
import domain.User;
import domain.Insurance;
import java.util.List;

public interface SalesService {

  List<Insurance> getInsuranceList();

  List<User> getEmployeeList();

  void createCustomer(Customer customer);

  List<Customer> getCustomerList();

  void createContract(Insurance insurance, Customer customer);

  List<Contract> getContractList();

  List<Contract> getUWCompletedContracts();

  void makeContractSigned(int id);

  void removeContract(int id);
}
