package com.insurancefraudgroup.insurancesystem.service;

import com.insurancefraudgroup.insurancesystem.domain.Underwriting;
import com.insurancefraudgroup.insurancesystem.dto.UnderwritingServiceDto;

public interface UnderwritingService {

  void create(UnderwritingServiceDto dto);

  void delete(int id);

  Underwriting read(int id);

  void update(UnderwritingServiceDto dto);
}
