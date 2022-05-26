package service;

import domain.Contract;
import dto.ContractServiceDto;

public interface ContractService {

  void create(ContractServiceDto dto);

  void delete(int id);

  Contract read(int id);

  void update(ContractServiceDto dto);
}
