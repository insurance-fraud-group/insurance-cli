package service.impl;

import domain.Insurance;
import java.util.List;
import repository.InsuranceRepository;
import repository.UnderwritingRepository;
import service.InsuranceDesignService;

public class InsuranceDesignServiceImpl implements InsuranceDesignService {

  private final InsuranceRepository insuranceRepository;
  private final UnderwritingRepository underwritingRepository;

  public InsuranceDesignServiceImpl() {
    insuranceRepository = new InsuranceRepository();
    underwritingRepository = new UnderwritingRepository();
  }

  @Override
  public List<Insurance> searchInsurance() {
    return insuranceRepository.findAll();
  }

  @Override
  public void designInsurance(Insurance insurance) {
    insuranceRepository.save(insurance);
  }

  @Override
  public void requestInsuranceApproval(String insuranceCode) {
    underwritingRepository.setInsuranceCode(insuranceCode);
  }
}
