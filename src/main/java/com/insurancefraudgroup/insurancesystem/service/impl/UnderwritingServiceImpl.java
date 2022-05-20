package com.insurancefraudgroup.insurancesystem.service.impl;

import com.insurancefraudgroup.insurancesystem.domain.Underwriting;
import com.insurancefraudgroup.insurancesystem.dto.UnderwritingServiceDto;

import java.util.ArrayList;
import java.util.List;
import com.insurancefraudgroup.insurancesystem.service.UnderwritingService;

public class UnderwritingServiceImpl implements UnderwritingService {

  private final List<Underwriting> underwritingList;

  public UnderwritingServiceImpl() {
    underwritingList = new ArrayList<>();
  }

  public void create(UnderwritingServiceDto dto) {
    Underwriting underwriting = new Underwriting(dto);
    underwritingList.add(underwriting);
  }

  public void delete(int id) {
    underwritingList.remove(id);
  }

  public Underwriting read(int id) {
    return underwritingList.get(id);
  }

  public void update(UnderwritingServiceDto dto) {
    int id = dto.getId();
    Underwriting underwriting = underwritingList.get(id);
    underwriting.update(dto);
  }
}
