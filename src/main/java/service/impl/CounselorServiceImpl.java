package service.impl;

import repository.CustomerRepository;
import service.CounselorService;


public class CounselorServiceImpl implements CounselorService {

  private final CustomerRepository customerRepository;

  public CounselorServiceImpl() {
    customerRepository = new CustomerRepository();
  }

  @Override
  public void counsel() {
  }

  @Override
  public void receiveAccident() {

  }
}

