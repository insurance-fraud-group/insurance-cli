package domain;

import domain.employee.compensation.AccidentInvestigator;
import java.io.File;
import java.util.List;

public class Dispatch {

  private int id;
  private Accident accident;
  private String accidentDescription;
  private AccidentInvestigator accidentInvestigator;
  private int damage;
  private List<File> evidenceMedia;

  public Dispatch() {

  }
}
