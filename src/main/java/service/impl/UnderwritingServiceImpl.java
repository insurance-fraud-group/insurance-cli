package service.impl;

import domain.Underwriting;

import java.util.ArrayList;
import java.util.List;
import service.UnderwritingService;

public class UnderwritingServiceImpl implements UnderwritingService {

  private final List<Underwriting> underwritingList;

  public UnderwritingServiceImpl() {
    underwritingList = new ArrayList<>();
  }

}
