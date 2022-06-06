package service.impl;

import domain.Contract;
import domain.Customer;
import domain.Insurance;
import domain.Transaction;
import domain.Underwriting;
import domain.User;
import domain.enums.TransactionType;
import java.util.List;
import java.util.stream.Collectors;
import repository.ContractRepository;
import repository.CustomerRepository;
import repository.EmployeeRepository;
import repository.InsuranceRepository;
import repository.TransactionRepository;
import repository.UnderwritingRepository;
import service.SalesService;
import utils.Session;

public class SalesServiceImpl implements SalesService {

  private final InsuranceRepository insuranceRepository;
  private final EmployeeRepository userRepository;
  private final CustomerRepository customerRepository;
  private final ContractRepository contractRepository;
  private final UnderwritingRepository underwritingRepository;
  private final TransactionRepository transactionRepository;

  public SalesServiceImpl() {
    insuranceRepository = new InsuranceRepository();
    userRepository = new EmployeeRepository();
    customerRepository = new CustomerRepository();
    contractRepository = new ContractRepository();
    underwritingRepository = new UnderwritingRepository();
    transactionRepository = new TransactionRepository();
  }

  @Override
  public List<Insurance> getInsuranceList() {
    return insuranceRepository.findAll();
  }

  @Override
  public List<User> getEmployeeList() {
    return userRepository.findAll();
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
    Contract contract = Contract.builder().insurance(insurance).customer(customer).signed(false)
        .build();
    contractRepository.save(contract);

    underwritingRepository.save(
        Underwriting.builder().writer(Session.getSession().getUser()).contract(contract)
            .signed(false).build());
  }

  @Override
  public List<Contract> getContractList() {
    return contractRepository.findAll();
  }

  @Override
  public List<Contract> getContractList(Customer customer) {
    return customer.getContractList();
  }

  @Override
  public List<Contract> getUWCompletedContracts() {
    List<Contract> unsignedContractList = contractRepository.findAllBy("signed", false);
    return unsignedContractList != null ? unsignedContractList.stream()
        .filter(contract -> contract.getUnderwriting().isSigned()).collect(Collectors.toList())
        : null;
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

  public void managePayment(int payment, Contract contract) {
    Transaction transaction = Transaction.builder().amount(payment).contract(contract)
        .type(TransactionType.DEPOSIT).build();
    transactionRepository.save(transaction);
  }
}
