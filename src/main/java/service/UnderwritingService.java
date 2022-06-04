package service;

import domain.Underwriting;
import java.util.List;

public interface UnderwritingService {

  List<Underwriting> searchAcceptancePolicy();

  void createAcceptancePolicy(Underwriting underwriting);

  void manageLossRate();

  void underwrite();

  void manageCollaboration();

  void manageReinsurance();
}
