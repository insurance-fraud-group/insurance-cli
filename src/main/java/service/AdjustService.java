package service;

import domain.Adjust;
import dto.AdjustServiceDto;

public interface AdjustService {

  void create(AdjustServiceDto dto);

  void delete(int id);

  Adjust read(int id);

  void update(AdjustServiceDto dto);
}
