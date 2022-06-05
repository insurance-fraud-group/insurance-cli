package service;

import domain.AcceptancePolicy;
import domain.Employee;
import domain.Underwriting;
import java.util.List;

public interface UnderwritingService {

  List<AcceptancePolicy> searchAcceptancePolicy();

  void createAcceptancePolicy(AcceptancePolicy acceptancePolicy);

  Employee getEmployeeName(Employee employee);

  List<Underwriting> searchUnderwriting();

  boolean underwrite(Underwriting underwriting);

  void manageCollaboration();

  void manageReinsurance();
}
