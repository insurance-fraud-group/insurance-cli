package service;

import domain.AcceptancePolicy;
import domain.User;
import domain.Underwriting;
import java.util.List;

public interface UnderwritingService {

  List<AcceptancePolicy> searchAcceptancePolicy();

  void createAcceptancePolicy(AcceptancePolicy acceptancePolicy);

  User getEmployeeName(User user);

  List<Underwriting> searchUnderwriting();

  List<Underwriting> searchUnsignedUnderwriting();

  boolean underwrite(Underwriting underwriting);

  void manageCollaboration();

  void manageReinsurance();
}
