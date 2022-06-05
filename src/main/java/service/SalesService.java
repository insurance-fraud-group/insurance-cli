package service;

import domain.Contract;
import domain.Customer;
import domain.Employee;
import domain.Insurance;
import java.util.List;

public interface SalesService {

  List<Insurance> getInsuranceList();

  Insurance getInsurance(String insuranceCode);

  List<Employee> getEmployeeList();

  Employee getEmployee(int id);

  void createCustomer(Customer customer);

  List<Customer> getCustomerList();

  Customer getCustomer(int id);

  void createContract(Insurance insurance, Customer customer);

  List<Contract> getContractList();

  List<Contract> getUnsignedContractList();

  Contract getContract(int id);

  void makeContractSigned(int id);

  void removeContract(int id);
}
