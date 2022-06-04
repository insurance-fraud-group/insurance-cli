package service.impl;

import domain.Insurance;
import domain.enums.AuthorizeType;
import java.util.List;
import repository.InsuranceRepository;
import repository.UnderwritingRepository;
import service.InsuranceDesignService;

public class InsuranceDesignServiceImpl implements InsuranceDesignService {

  private final InsuranceRepository insuranceRepository = new InsuranceRepository();
  private final UnderwritingRepository underwritingRepository = new UnderwritingRepository();

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
    Insurance request = insuranceRepository.findById(insuranceCode);
    request.setAuthorizeType(AuthorizeType.AUTHORIZE_REQUEST);
    insuranceRepository.update(request);
  }
}
