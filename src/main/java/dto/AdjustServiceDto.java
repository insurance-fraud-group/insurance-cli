package dto;

import domain.Accident;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AdjustServiceDto {

  private int id;
  private Accident accident;
  private String basis;
  private boolean indemnity;
  private int payment;
}
