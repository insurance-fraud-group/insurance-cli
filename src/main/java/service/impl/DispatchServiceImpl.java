package service.impl;

import domain.Dispatch;
import java.util.ArrayList;
import java.util.List;
import service.DispatchService;

public class DispatchServiceImpl implements DispatchService {

  private final List<Dispatch> dispatchList;

  public DispatchServiceImpl() {
  dispatchList = new ArrayList<>();
  }

}
