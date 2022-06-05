package service.impl;

import domain.AcceptancePolicy;
import domain.Employee;
import domain.Insurance;
import domain.Underwriting;
import domain.enums.AuthorizeType;
import java.util.List;
import repository.AcceptancePolicyRepository;
import repository.EmployeeRepository;
import repository.InsuranceRepository;
import repository.UnderwritingRepository;
import service.UnderwritingService;

public class UnderwritingServiceImpl implements UnderwritingService {

  private final UnderwritingRepository underwritingRepository;
  private final AcceptancePolicyRepository acceptancePolicyRepository;
  private final InsuranceRepository insuranceRepository;
  private final EmployeeRepository employeeRepository;

  public UnderwritingServiceImpl() {
    underwritingRepository = new UnderwritingRepository();
    insuranceRepository = new InsuranceRepository();
    employeeRepository = new EmployeeRepository();
    acceptancePolicyRepository = new AcceptancePolicyRepository();
  }

  public List<Insurance> getInsuranceList() {
    return insuranceRepository.findAll();
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
  public List<Insurance> manageLossRate() {
    return getInsuranceList();
  }

  @Override
  public boolean underwrite(Underwriting underwriting) {
    underwritingRepository.save(underwriting);

    Underwriting uw = underwritingRepository.findById(underwriting.getId());
    int pfs = uw.getPhysicalFactorScore();
    int mfs = uw.getMoralFactorScore();
    int ffs = uw.getFinancialFactorScore();
    int efs = uw.getEnvironmentalFactorScore();

    return pfs + mfs + ffs + efs > 13;
  }

  public void updateInsuranceApproval(Insurance insurance, boolean result) {
    insurance.setAuthorizeType(
        result ? AuthorizeType.AUTHORIZE_PERMITTED : AuthorizeType.AUTHORIZE_DENIED);
    insuranceRepository.update(insurance);
  }

  @Override
  public void manageCollaboration() {

  }

  @Override
  public void manageReinsurance() {

  }
}
