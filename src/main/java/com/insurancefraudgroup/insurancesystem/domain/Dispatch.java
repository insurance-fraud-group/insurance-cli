package com.insurancefraudgroup.insurancesystem.domain;

import com.insurancefraudgroup.insurancesystem.domain.employee.compensation.AccidentInvestigator;
import com.insurancefraudgroup.insurancesystem.dto.DispatchServiceDto;
import java.io.File;
import java.util.List;

public class Dispatch {

  private int id;
  private Accident accident;
  private String accidentDescription;
  private AccidentInvestigator accidentInvestigator;
  private int damage;
  private List<File> evidenceMedia;

  public Dispatch(DispatchServiceDto dto) {
    this.id = dto.getId();
    this.accident = dto.getAccident();
    this.accidentDescription = dto.getAccidentDescription();
    this.damage = dto.getDamage();
    this.evidenceMedia = dto.getEvidenceMedia();
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

  public void update(DispatchServiceDto dto) {
    this.accident = dto.getAccident();
    this.accidentDescription = dto.getAccidentDescription();
    this.damage = dto.getDamage();
    this.evidenceMedia = dto.getEvidenceMedia();
  }
}
