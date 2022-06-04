package service;

import domain.Underwriting;
import java.util.List;

public interface UnderwritingService {

  List<Underwriting> createAcceptancePolicy();

  void manageLossRate();

  void underwrite();

  void manageCollaboration();

  void manageReinsurance();
}
