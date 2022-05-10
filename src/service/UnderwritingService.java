package service;

import domain.Underwriting;
import dto.UnderwritingServiceDto;

public interface UnderwritingService {

  void create(UnderwritingServiceDto dto);

  void delete(int id);

  Underwriting read(int id);

  void update(UnderwritingServiceDto dto);
}
