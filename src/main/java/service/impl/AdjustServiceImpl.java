package service.impl;

import domain.Adjust;
import java.util.ArrayList;
import java.util.List;
import service.AdjustService;

public class AdjustServiceImpl implements AdjustService {

  private final List<Adjust> adjustList;

  public AdjustServiceImpl() {
   adjustList = new ArrayList<>();
  }

}
