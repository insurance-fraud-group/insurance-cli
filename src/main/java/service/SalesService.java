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

  List<Contract> getUnsignedContract();

  Contract getContract(int id);

  Contract makeContractSigned(int id);
}
