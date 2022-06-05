package service.impl;

import domain.AcceptancePolicy;
import domain.Employee;
import domain.Underwriting;
import java.util.List;
import repository.AcceptancePolicyRepository;
import repository.EmployeeRepository;
import repository.UnderwritingRepository;
import service.UnderwritingService;

public class UnderwritingServiceImpl implements UnderwritingService {

  private final UnderwritingRepository underwritingRepository;
  private final AcceptancePolicyRepository acceptancePolicyRepository;
  private final EmployeeRepository employeeRepository;

  public UnderwritingServiceImpl() {
    underwritingRepository = new UnderwritingRepository();
    employeeRepository = new EmployeeRepository();
    acceptancePolicyRepository = new AcceptancePolicyRepository();
  }

  public Employee getEmployeeName(Employee employee) {
    return employeeRepository.findBy("name", employee);
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
        + underwriting.getEnvironmentalFactorScore() > 13;
  }

  @Override
  public void manageCollaboration() {

  }

  @Override
  public void manageReinsurance() {

  }
}
