package service.impl;

import domain.Contract;
import domain.Customer;
import domain.Employee;
import domain.Insurance;
import domain.Underwriting;
import java.util.List;
import repository.ContractRepository;
import repository.CustomerRepository;
import repository.EmployeeRepository;
import repository.InsuranceRepository;
import repository.UnderwritingRepository;
import service.SalesService;
import utils.Session;

public class SalesServiceImpl implements SalesService {

  private final InsuranceRepository insuranceRepository;
  private final EmployeeRepository employeeRepository;
  private final CustomerRepository customerRepository;
  private final ContractRepository contractRepository;
  private final UnderwritingRepository underwritingRepository;

  public SalesServiceImpl() {
    insuranceRepository = new InsuranceRepository();
    employeeRepository = new EmployeeRepository();
    customerRepository = new CustomerRepository();
    contractRepository = new ContractRepository();
    underwritingRepository = new UnderwritingRepository();
  }

  @Override
  public List<Insurance> getInsuranceList() {
    return insuranceRepository.findAll();
  }

  @Override
  public List<Employee> getEmployeeList() {
    return employeeRepository.findAll();
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
  public void createContract(Insurance insurance, Customer customer) {
    Contract contract = Contract.builder()
        .insurance(insurance).customer(customer)
        .signed(false).build();

    contractRepository.save(contract);
    underwritingRepository.save(Underwriting.builder()
        .writer(Session.getSession().getUser())
        .contract(contract).signed(false).build());
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
  public void makeContractSigned(int id) {
    Contract contract = contractRepository.findById(id);
    contract.setSigned(true);
    contractRepository.update(contract);
  }

  @Override
  public void removeContract(int id) {
    Contract contract = contractRepository.findById(id);
    contractRepository.delete(contract);
  }
}
