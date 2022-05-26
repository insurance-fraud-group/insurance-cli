package service.impl;

import domain.Adjust;
import dto.AdjustServiceDto;

import java.util.ArrayList;
import java.util.List;
import service.AdjustService;

public class AdjustServiceImpl implements AdjustService {

  private final List<Adjust> adjustList;

  public AdjustServiceImpl() {
   adjustList = new ArrayList<>();
  }

  public void create(AdjustServiceDto dto) {
    Adjust adjust = new Adjust(dto);
    adjustList.add(adjust);
  }

  public void delete(int id) {
    adjustList.remove(id);
  }

  public Adjust read(int id) {
    return adjustList.get(id);
  }

  public void update(AdjustServiceDto dto) {
    int id = dto.getId();
    Adjust adjust = adjustList.get(id);
    adjust.update(dto);
  }
}
