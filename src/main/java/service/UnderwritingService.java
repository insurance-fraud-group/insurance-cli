package service;

import domain.AcceptancePolicy;
import domain.InsuranceCompany;
import domain.Underwriting;
import domain.User;
import java.util.List;

public interface UnderwritingService {

  List<AcceptancePolicy> searchAcceptancePolicy();

  void createAcceptancePolicy(AcceptancePolicy acceptancePolicy);

  User getEmployeeName(User user);

  List<Underwriting> searchUnderwriting();

  List<Underwriting> searchUnsignedUnderwriting();

  boolean underwrite(Underwriting underwriting);

  List<InsuranceCompany> searchInsuranceCompany();

  void makeUnderwritingSigned(Underwriting underwriting);
}
