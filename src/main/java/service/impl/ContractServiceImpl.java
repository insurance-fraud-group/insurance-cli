package service.impl;

import domain.Contract;
import java.util.ArrayList;
import java.util.List;
import service.ContractService;

public class ContractServiceImpl implements ContractService {

  private final List<Contract> contractList;

  public ContractServiceImpl() {
    contractList = new ArrayList<>();
  }

}
