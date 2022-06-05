package service;

import domain.AcceptancePolicy;
import domain.Employee;
import domain.Insurance;
import domain.Underwriting;
import java.util.List;

public interface UnderwritingService {

  List<AcceptancePolicy> searchAcceptancePolicy();

  void createAcceptancePolicy(AcceptancePolicy acceptancePolicy);

  Employee getEmployeeName(Employee employee);

  List<Insurance> manageLossRate();

  boolean underwrite(Underwriting underwriting);

  void updateInsuranceApproval(Insurance insurance, boolean result);

  void manageCollaboration();

  void manageReinsurance();
}
