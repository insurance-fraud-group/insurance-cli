package com.insurancefraudgroup.insurancesystem.service.impl;

import com.insurancefraudgroup.insurancesystem.domain.Dispatch;
import com.insurancefraudgroup.insurancesystem.dto.DispatchServiceDto;

import java.util.ArrayList;
import java.util.List;
import com.insurancefraudgroup.insurancesystem.service.DispatchService;

public class DispatchServiceImpl implements DispatchService {

  private final List<Dispatch> dispatchList;

  public DispatchServiceImpl() {
  dispatchList = new ArrayList<>();
  }

  public void create(DispatchServiceDto dto) {
    Dispatch dispatch = new Dispatch(dto);
    dispatchList.add(dispatch);
  }

  public void delete(int id) {
    dispatchList.remove(id);
  }

  public Dispatch read(int id) {
    return dispatchList.get(id);
  }

  public void update(DispatchServiceDto dto) {
    int id = dto.getId();
    Dispatch dispatch = dispatchList.get(id);
    dispatch.update(dto);
  }
}
