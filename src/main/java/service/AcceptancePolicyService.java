package service;

import domain.AcceptancePolicy;
import dto.AcceptancePolicyDto;

public interface AcceptancePolicyService {

  void create(AcceptancePolicyDto dto);

  void delete(int id);

  AcceptancePolicy read(int id);

  void update(AcceptancePolicyDto dto);
}
