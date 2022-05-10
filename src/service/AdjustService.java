package service;

import domain.Adjust;

public interface AdjustService {

  void create(Adjust adjust);

  void delete(int id);

  Adjust read();

  void update(Adjust adjust);
}
