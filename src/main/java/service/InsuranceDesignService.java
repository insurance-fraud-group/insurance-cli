package service;

import domain.Insurance;
import domain.enums.InsuranceType;
import java.util.List;

public interface InsuranceDesignService {

  List<Insurance> searchInsurance();

  void designInsurance(Insurance insurance);

  void requestInsuranceApproval(Insurance insurance);

  int getCountByInsuranceType(InsuranceType insuranceType);

}
