package service;

import domain.Insurance;
import java.util.List;

public interface InsuranceDesignService {

  List<Insurance> searchInsurance();

  void designInsurance(Insurance insurance) ;

  void requestInsuranceApproval(String insuranceCode);

}
