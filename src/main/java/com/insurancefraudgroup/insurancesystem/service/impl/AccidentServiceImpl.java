package com.insurancefraudgroup.insurancesystem.service.impl;

import com.insurancefraudgroup.insurancesystem.domain.Accident;
import com.insurancefraudgroup.insurancesystem.dto.AccidentServiceDto;

import java.util.ArrayList;
import java.util.List;
import com.insurancefraudgroup.insurancesystem.service.AccidentService;

public class AccidentServiceImpl implements AccidentService {

  private final List<Accident> accidentList;

  public AccidentServiceImpl() {
    accidentList = new ArrayList<>();
  }

  public void create(AccidentServiceDto dto) {
    Accident accident = new Accident(dto);
    accidentList.add(accident);
  }

  public void delete(int id) {
    accidentList.remove(id);
  }

  public Accident read(int id) {
    return accidentList.get(id);
  }

  public void update(AccidentServiceDto dto) {
    int id = dto.getId();
    Accident accident = accidentList.get(id);
    accident.update(dto);
  }
}
