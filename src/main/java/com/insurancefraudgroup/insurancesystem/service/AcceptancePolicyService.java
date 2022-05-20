package com.insurancefraudgroup.insurancesystem.service;

import com.insurancefraudgroup.insurancesystem.domain.AcceptancePolicy;
import com.insurancefraudgroup.insurancesystem.dto.AcceptancePolicyDto;

public interface AcceptancePolicyService {

  void create(AcceptancePolicyDto dto);

  void delete(int id);

  AcceptancePolicy read(int id);

  void update(AcceptancePolicyDto dto);
}
