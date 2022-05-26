package dto;

import domain.Customer;
import domain.Product;
import java.io.File;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ContractServiceDto {

  private int id;
  private boolean completion;
  private Customer customer;
  private Product product;
  private File subscription;
}
