package service;

import domain.Contract;
import domain.Customer;
import domain.Insurance;
import domain.User;
import java.util.List;

public interface SalesService {

  List<Insurance> getInsuranceList();

  List<User> getEmployeeList();

  void createCustomer(Customer customer);

  List<Customer> getCustomerList();

  void createContract(Insurance insurance, Customer customer);

  List<Contract> getContractList();

  List<Contract> getContractList(Customer customer);

  List<Contract> getUWCompletedContracts();

  void makeContractSigned(int id);

  void removeContract(int id);
}
