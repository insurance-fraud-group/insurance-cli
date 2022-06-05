package service.impl;

import domain.Accident;
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
  public List<Customer> counsel() {
    return customerRepository.findAll();
  }

  @Override
  public List<Accident> receiveAccident(Accident accident) {
    accidentRepository.save(accident);
    return accidentRepository.findAll();
  }
}

