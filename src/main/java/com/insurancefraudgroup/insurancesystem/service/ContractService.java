package com.insurancefraudgroup.insurancesystem.service;

import com.insurancefraudgroup.insurancesystem.domain.Contract;
import com.insurancefraudgroup.insurancesystem.dto.ContractServiceDto;

public interface ContractService {

  void create(ContractServiceDto dto);

  void delete(int id);

  Contract read(int id);

  void update(ContractServiceDto dto);
}
