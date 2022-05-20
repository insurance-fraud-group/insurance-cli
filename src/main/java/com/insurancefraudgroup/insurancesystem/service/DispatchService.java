package com.insurancefraudgroup.insurancesystem.service;

import com.insurancefraudgroup.insurancesystem.domain.Dispatch;
import com.insurancefraudgroup.insurancesystem.dto.DispatchServiceDto;

public interface DispatchService {

  void create(DispatchServiceDto dto);

  void delete(int id);

  Dispatch read(int id);

  void update(DispatchServiceDto dto);
}
