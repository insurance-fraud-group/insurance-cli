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

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Accident getAccident() {
    return accident;
  }

  public void setAccident(Accident accident) {
    this.accident = accident;
  }

  public String getAccidentDescription() {
    return accidentDescription;
  }

  public void setAccidentDescription(String accidentDescription) {
    this.accidentDescription = accidentDescription;
  }

  public AccidentInvestigator getAccidentInvestigator() {
    return accidentInvestigator;
  }

  public void setAccidentInvestigator(
          AccidentInvestigator accidentInvestigator) {
    this.accidentInvestigator = accidentInvestigator;
  }

  public int getDamage() {
    return damage;
  }

  public void setDamage(int damage) {
    this.damage = damage;
  }

  public List<File> getEvidenceMedia() {
    return evidenceMedia;
  }

  public void setEvidenceMedia(List<File> evidenceMedia) {
    this.evidenceMedia = evidenceMedia;
  }
}
