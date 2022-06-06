package service.impl;

import domain.Insurance;
import domain.enums.InsuranceType;
import java.util.List;
import repository.InsuranceRepository;
import service.InsuranceDesignService;

public class InsuranceDesignServiceImpl implements InsuranceDesignService {

  private final InsuranceRepository insuranceRepository;

  public InsuranceDesignServiceImpl() {
    insuranceRepository = new InsuranceRepository();
  }

  @Override
  public int getCountByInsuranceType(InsuranceType insuranceType) {
    return insuranceRepository.findAllBy("insuranceType", insuranceType).size();
  }

  @Override
  public List<Insurance> searchInsurance() {
    return insuranceRepository.findAll();
  }

  @Override
  public void designInsurance(Insurance insurance) {
    insuranceRepository.save(insurance);
  }
}
