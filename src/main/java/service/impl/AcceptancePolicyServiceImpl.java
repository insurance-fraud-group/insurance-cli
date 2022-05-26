package service.impl;

import domain.AcceptancePolicy;
import java.util.ArrayList;
import java.util.List;
import service.AcceptancePolicyService;

public class AcceptancePolicyServiceImpl implements AcceptancePolicyService {

  private final List<AcceptancePolicy> acceptancePolicyList;

  public AcceptancePolicyServiceImpl() {
    acceptancePolicyList = new ArrayList<>();
  }

}
