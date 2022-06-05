package service.impl;

import domain.Contract;
import domain.Customer;
import domain.Employee;
import domain.Insurance;
import java.util.List;
import repository.ContractRepository;
import repository.CustomerRepository;
import repository.EmployeeRepository;
import repository.InsuranceRepository;
import service.SalesService;

public class SalesServiceImpl implements SalesService {

  private final InsuranceRepository insuranceRepository;
  private final EmployeeRepository employeeRepository;
  private final CustomerRepository customerRepository;
  private final ContractRepository contractRepository;

  public SalesServiceImpl() {
    insuranceRepository = new InsuranceRepository();
    employeeRepository = new EmployeeRepository();
    customerRepository = new CustomerRepository();
    contractRepository = new ContractRepository();
  }

  @Override
  public List<Insurance> getInsuranceList() {
    return insuranceRepository.findAll();
  }

  @Override
  public Insurance getInsurance(String insuranceCode) {
    return insuranceRepository.findById(insuranceCode);
  }

  @Override
  public List<Employee> getEmployeeList() {
    return employeeRepository.findAll();
  }

  @Override
  public Employee getEmployee(int id) {
    return employeeRepository.findById(id);
  }

  @Override
  public void createCustomer(Customer customer) {
    customerRepository.save(customer);
  }

  @Override
  public List<Customer> getCustomerList() {
    return customerRepository.findAll();
  }

  @Override
  public Customer getCustomer(int id) {
    return customerRepository.findById(id);
  }

  @Override
  public void createContract(Insurance insurance, Customer customer) {
    contractRepository.save(Contract.builder()
        .insurance(insurance)
        .customer(customer)
        .signed(false)
        .build());
  }

  @Override
  public List<Contract> getContractList() {
    return contractRepository.findAll();
  }

  @Override
  public List<Contract> getUnsignedContractList() {
    return contractRepository.findAllBy("signed", false);
  }

  @Override
  public Contract getContract(int id) {
    return contractRepository.findById(id);
  }

  @Override
  public Contract makeContractSigned(int id) {
    Contract contract = contractRepository.findById(id);
    contract.setSigned(true);
    contractRepository.update(contract);
    return contract;
  }
}
