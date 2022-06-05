package service;

import domain.Accident;
import domain.Customer;
import java.util.List;

public interface CounselorService {

  List<Accident> receiveAccident(Accident accident);

  List<Customer> counsel();
}
