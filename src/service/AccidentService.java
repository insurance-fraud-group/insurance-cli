package service;

import domain.Accident;
import dto.AccidentServiceDto;

public interface AccidentService {

  void create(AccidentServiceDto dto);

  void delete(int id);

  Accident read(int id);

  void update(AccidentServiceDto dto);
}
