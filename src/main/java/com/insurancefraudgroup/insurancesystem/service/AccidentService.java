package com.insurancefraudgroup.insurancesystem.service;

import com.insurancefraudgroup.insurancesystem.domain.Accident;
import com.insurancefraudgroup.insurancesystem.dto.AccidentServiceDto;

public interface AccidentService {

  void create(AccidentServiceDto dto);

  void delete(int id);

  Accident read(int id);

  void update(AccidentServiceDto dto);
}
