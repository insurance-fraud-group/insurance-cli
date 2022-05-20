package com.insurancefraudgroup.insurancesystem.service;

import com.insurancefraudgroup.insurancesystem.domain.Adjust;
import com.insurancefraudgroup.insurancesystem.dto.AdjustServiceDto;

public interface AdjustService {

  void create(AdjustServiceDto dto);

  void delete(int id);

  Adjust read(int id);

  void update(AdjustServiceDto dto);
}
