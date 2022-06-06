package service.impl;

import domain.AcceptancePolicy;
import domain.InsuranceCompany;
import domain.Underwriting;
import domain.User;
import java.util.List;
import repository.AcceptancePolicyRepository;
import repository.EmployeeRepository;
import repository.InsuranceCompanyRepository;
import repository.UnderwritingRepository;
import service.UnderwritingService;

public class UnderwritingServiceImpl implements UnderwritingService {

  private final UnderwritingRepository underwritingRepository;
  private final AcceptancePolicyRepository acceptancePolicyRepository;
  private final EmployeeRepository userRepository;
  private final InsuranceCompanyRepository insuranceCompanyRepository;

  public UnderwritingServiceImpl() {
    underwritingRepository = new UnderwritingRepository();
    userRepository = new EmployeeRepository();
    acceptancePolicyRepository = new AcceptancePolicyRepository();
    insuranceCompanyRepository = new InsuranceCompanyRepository();
  }

  public User getEmployeeName(User user) {
    return userRepository.findBy("name", user);
  }

  @Override
  public List<AcceptancePolicy> searchAcceptancePolicy() {
    return acceptancePolicyRepository.findAll();
  }

  @Override
  public void createAcceptancePolicy(AcceptancePolicy acceptancePolicy) {
    acceptancePolicyRepository.save(acceptancePolicy);
  }

  @Override
  public List<Underwriting> searchUnderwriting() {
    return underwritingRepository.findAll();
  }

  @Override
  public List<Underwriting> searchUnsignedUnderwriting() {
    return underwritingRepository.findAllBy("signed", false);
  }

  @Override
  public boolean underwrite(Underwriting underwriting) {
    boolean signed = checkSigned(underwriting);
    underwriting.setSigned(signed);
    underwritingRepository.update(underwriting);
    return signed;
  }

  private boolean checkSigned(Underwriting underwriting) {
    return underwriting.getPhysicalFactorScore()
        + underwriting.getMoralFactorScore()
        + underwriting.getFinancialFactorScore()
        + underwriting.getEnvironmentalFactorScore() > 10;
  }

  @Override
  public List<InsuranceCompany> searchInsuranceCompany() {
    return insuranceCompanyRepository.findAll();
  }

  @Override
  public void makeUnderwritingSigned(Underwriting underwriting) {
    underwriting.setSigned(true);
    underwritingRepository.update(underwriting);
  }
}
