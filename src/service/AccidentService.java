package service;

import domain.Accident;

public interface AccidentService {

  void create(Accident accident);

  void delete(int id);

  Accident read(int id);

  void update(Accident accident);
}
