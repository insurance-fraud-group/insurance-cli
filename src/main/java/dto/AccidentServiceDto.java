package dto;

import domain.Customer;
import enums.AccidentType;
import java.awt.geom.Point2D;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AccidentServiceDto {

  private int id;
  private Customer customer;
  private Point2D eventLocation;
  private LocalDateTime eventTime;
  private boolean victim;
  private AccidentType accidentType;
}
