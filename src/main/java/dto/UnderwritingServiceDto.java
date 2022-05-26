package dto;

import domain.Customer;
import domain.product.Product;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UnderwritingServiceDto {

  private int id;
  private Customer customer;
  private int environmentalFactorScore;
  private int financialFactorScore;
  private int moralFactorScore;
  private int physicalFactorScore;
  private Product product;
}
