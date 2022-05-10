package service.impl;

import domain.AcceptancePolicy;
import dto.AcceptancePolicyDto;
import java.util.ArrayList;
import java.util.List;
import service.AcceptancePolicyService;

public class AcceptancePolicyServiceImpl implements AcceptancePolicyService {

  private List<AcceptancePolicy> acceptancePolicyList;

  public AcceptancePolicyServiceImpl() {
    acceptancePolicyList = new ArrayList<>();
  }

  public void create(AcceptancePolicyDto dto) {
    AcceptancePolicy acceptancePolicy = new AcceptancePolicy(dto);
    acceptancePolicyList.add(acceptancePolicy);
  }

  public void delete(int id) {
    acceptancePolicyList.remove(id);
  }

  public AcceptancePolicy read(int id) {
    return acceptancePolicyList.get(id);
  }

  public void update(AcceptancePolicyDto dto) {
    int id = dto.getId();
    AcceptancePolicy acceptancePolicy = acceptancePolicyList.get(id);
    acceptancePolicy.update(dto);
  }
}
