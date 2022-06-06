package service.impl;

import domain.Accident;
import domain.Contract;
import domain.Customer;
import java.util.List;
import repository.AccidentRepository;
import repository.CustomerRepository;
import service.CounselorService;


public class CounselorServiceImpl implements CounselorService {

  private final CustomerRepository customerRepository;
  private final AccidentRepository accidentRepository;

  public CounselorServiceImpl() {
    customerRepository = new CustomerRepository();
    accidentRepository = new AccidentRepository();
  }

  @Override
  public List<Customer> getCustomerList() {
    return customerRepository.findAll();
  }

  @Override
  public List<Contract> getContractList(Customer customer) {
    return customer.getContractList();
  }

  @Override
  public void registerAccident(Accident accident) {
    accidentRepository.save(accident);
  }

  @Override
  public List<Accident> searchAccident() {
    return accidentRepository.findAll();
  }
}

