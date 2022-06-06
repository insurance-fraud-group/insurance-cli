package service;

import domain.Accident;
import domain.Contract;
import domain.Customer;
import java.util.List;

public interface CounselorService {

  List<Contract> getContractList(Customer customer);

  void registerAccident(Accident accident);

  List<Customer> getCustomerList();
}
