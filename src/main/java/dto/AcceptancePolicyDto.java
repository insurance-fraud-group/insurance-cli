package dto;

import domain.Employee;
import java.util.Date;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AcceptancePolicyDto {

  private int id;
  private Date createdDate;
  private String description;
  private String name;
  private Employee writer;
}
