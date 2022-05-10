package service;

import domain.Underwriting;

public interface UnderwritingService {

  void create(Underwriting underwriting);

  void delete(int id);

  Underwriting read(int id);

  void update(Underwriting underwriting);
}
