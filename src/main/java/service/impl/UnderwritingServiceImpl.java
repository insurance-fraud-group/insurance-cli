package service.impl;

import domain.Underwriting;
import java.util.List;
import repository.UnderwritingRepository;
import service.UnderwritingService;

public class UnderwritingServiceImpl implements UnderwritingService {

  private final UnderwritingRepository underwritingRepository = new UnderwritingRepository();
  @Override
  public List<Underwriting> createAcceptancePolicy() {
    return underwritingRepository.findAll();
  }

  @Override
  public void manageLossRate() {

  }

  @Override
  public void underwrite() {

  }

  @Override
  public void manageCollaboration() {

  }

  @Override
  public void manageReinsurance() {

  }
}
