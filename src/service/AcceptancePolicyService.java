package service;

import domain.AcceptancePolicy;

public interface AcceptancePolicyService {

  void create(AcceptancePolicy acceptancePolicy);

  void delete(int id);

  AcceptancePolicy read(int id);

  void update(AcceptancePolicy acceptancePolicy);
}
