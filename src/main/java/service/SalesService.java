package service;

import domain.Contract;
import domain.Customer;
import domain.Employee;
import domain.Insurance;
import java.util.List;

public interface SalesService {

  List<Insurance> getInsuranceList();

  List<Employee> getEmployeeList();

  void createCustomer(Customer customer);

  List<Customer> getCustomerList();

  void createContract(Insurance insurance, Customer customer);

  List<Contract> getContractList();

  List<Contract> getUnsignedContractList();

  void makeContractSigned(int id);

  void removeContract(int id);
}
