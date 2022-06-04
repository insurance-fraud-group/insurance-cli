package service.impl;

import domain.Employee;
import domain.Insurance;
import domain.Underwriting;
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
    return employeeRepository.findBy("name",employee.getName());
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
  public void underwrite() {

  }

  @Override
  public void manageCollaboration() {

  }

  @Override
  public void manageReinsurance() {

  }
}
