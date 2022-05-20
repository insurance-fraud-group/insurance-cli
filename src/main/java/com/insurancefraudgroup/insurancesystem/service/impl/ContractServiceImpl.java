package com.insurancefraudgroup.insurancesystem.service.impl;

import com.insurancefraudgroup.insurancesystem.domain.Contract;
import com.insurancefraudgroup.insurancesystem.dto.ContractServiceDto;

import java.util.ArrayList;
import java.util.List;
import com.insurancefraudgroup.insurancesystem.service.ContractService;

public class ContractServiceImpl implements ContractService {

  private final List<Contract> contractList;

  public ContractServiceImpl() {
    contractList = new ArrayList<>();
  }

  public void create(ContractServiceDto dto) {
    Contract contract = new Contract(dto);
    contractList.add(contract);
  }

  public void delete(int id) {
    contractList.remove(id);
  }

  public Contract read(int id) {
    return contractList.get(id);
  }

  public void update(ContractServiceDto dto) {
    int id = dto.getId();
    Contract contract = contractList.get(id);
    contract.update(dto);
  }
}
