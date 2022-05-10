package service;

import domain.Dispatch;

public interface DispatchService {

  void create(Dispatch dispatch);

  void delete(int id);

  Dispatch read(int id);

  void update(Dispatch dispatch);
}
