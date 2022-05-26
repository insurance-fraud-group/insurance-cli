package dto;

import domain.Accident;
import domain.employee.compensation.AccidentInvestigator;
import java.io.File;
import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DispatchServiceDto {

  private int id;
  private Accident accident;
  private String accidentDescription;
  private AccidentInvestigator accidentInvestigator;
  private int damage;
  private List<File> evidenceMedia;
}
