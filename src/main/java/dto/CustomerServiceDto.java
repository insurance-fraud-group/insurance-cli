package dto;

import java.time.LocalDate;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomerServiceDto {

  private int id;
  private String accountNumber;
  private String address;
  private LocalDate birth;
  private String job;
  private String name;
  private String phoneNumber;
  private boolean sex;
}
