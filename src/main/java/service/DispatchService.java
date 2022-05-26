package service;

import domain.Dispatch;
import dto.DispatchServiceDto;

public interface DispatchService {

  void create(DispatchServiceDto dto);

  void delete(int id);

  Dispatch read(int id);

  void update(DispatchServiceDto dto);
}
