package service.impl;

import domain.Underwriting;
import java.util.List;
import repository.UnderwritingRepository;
import service.UnderwritingService;

public class UnderwritingServiceImpl implements UnderwritingService {

  private final UnderwritingRepository underwritingRepository;

  public UnderwritingServiceImpl() {
    underwritingRepository = new UnderwritingRepository();
  }

  @Override
  public List<Underwriting> searchAcceptancePolicy() {
    return underwritingRepository.findAll();
  }

  @Override
  public void createAcceptancePolicy(Underwriting underwriting) {
    underwritingRepository.save(underwriting);
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
