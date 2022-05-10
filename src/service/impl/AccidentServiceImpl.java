package service.impl;

import domain.Accident;
import dto.AccidentServiceDto;
import java.util.List;
import service.AccidentService;

public class AccidentServiceImpl implements AccidentService {

  private List<Accident> accidentList;

  public AccidentServiceImpl() {

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
