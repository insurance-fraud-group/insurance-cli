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

  void underwrite();

  void manageCollaboration();

  void manageReinsurance();
}
