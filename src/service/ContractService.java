package service;

import domain.Contract;

public interface ContractService {

  void create(Contract contract);

  void delete(int id);

  Contract read(int id);

  void update(Contract contract);
}
