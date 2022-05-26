package service.impl;

import domain.Accident;
import java.util.ArrayList;
import java.util.List;
import service.AccidentService;

public class AccidentServiceImpl implements AccidentService {

  private final List<Accident> accidentList;

  public AccidentServiceImpl() {
    accidentList = new ArrayList<>();
  }

}
