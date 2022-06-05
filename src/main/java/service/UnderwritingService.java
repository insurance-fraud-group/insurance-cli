package service;

import domain.Employee;
import domain.Insurance;
import domain.Underwriting;
import java.util.List;

public interface UnderwritingService {

  List<Underwriting> searchAcceptancePolicy();

  void createAcceptancePolicy(Underwriting underwriting);

  Employee getEmployeeName(Employee employee);

  List<Insurance> manageLossRate();

  boolean underwrite(Underwriting underwriting);

  void updateInsuranceApproval(Insurance insurance, boolean result);

  void manageCollaboration();

  void manageReinsurance();


}
