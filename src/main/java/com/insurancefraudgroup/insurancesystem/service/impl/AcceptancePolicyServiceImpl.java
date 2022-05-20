package com.insurancefraudgroup.insurancesystem.service.impl;

import com.insurancefraudgroup.insurancesystem.domain.AcceptancePolicy;
import com.insurancefraudgroup.insurancesystem.dto.AcceptancePolicyDto;
import java.util.ArrayList;
import java.util.List;
import com.insurancefraudgroup.insurancesystem.service.AcceptancePolicyService;

public class AcceptancePolicyServiceImpl implements AcceptancePolicyService {

  private final List<AcceptancePolicy> acceptancePolicyList;

  public AcceptancePolicyServiceImpl() {
    acceptancePolicyList = new ArrayList<>();
  }

  public void create(AcceptancePolicyDto dto) {
    AcceptancePolicy acceptancePolicy = new AcceptancePolicy(dto);
    acceptancePolicyList.add(acceptancePolicy);
  }

  public void delete(int id) {
    acceptancePolicyList.remove(id);
  }

  public AcceptancePolicy read(int id) {
    return acceptancePolicyList.get(id);
  }

  public void update(AcceptancePolicyDto dto) {
    int id = dto.getId();
    AcceptancePolicy acceptancePolicy = acceptancePolicyList.get(id);
    acceptancePolicy.update(dto);
  }
}
