package service.impl;

import domain.Employee;
import domain.Insurance;
import domain.Underwriting;
import domain.enums.AuthorizeType;
import java.util.List;
import repository.EmployeeRepository;
import repository.InsuranceRepository;
import repository.UnderwritingRepository;
import service.UnderwritingService;

public class UnderwritingServiceImpl implements UnderwritingService {

  private final UnderwritingRepository underwritingRepository;
  private final InsuranceRepository insuranceRepository;
  private final EmployeeRepository employeeRepository;

  public UnderwritingServiceImpl() {
    underwritingRepository = new UnderwritingRepository();
    insuranceRepository = new InsuranceRepository();
    employeeRepository = new EmployeeRepository();
  }

  public List<Insurance> getInsuranceList() {
    return insuranceRepository.findAll();
  }


  public Employee getEmployeeName(Employee employee) {
    return employeeRepository.findBy("name", employee.getName());
  }

  @Override
  public List<Underwriting> searchAcceptancePolicy() {
    return underwritingRepository.findAll();
  }

  @Override
  public void createAcceptancePolicy(Underwriting underwriting) {
    underwritingRepository.save(underwriting);
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
    if (result) {
      insurance.setAuthorizeType(AuthorizeType.AUTHORIZE_PERMITTED);
    } else {
      insurance.setAuthorizeType(AuthorizeType.AUTHORIZE_DENIED);
    }
    insuranceRepository.update(insurance);
  }

  @Override
  public void manageCollaboration() {

  }

  @Override
  public void manageReinsurance() {

  }
}
