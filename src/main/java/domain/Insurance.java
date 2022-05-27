package domain;

import domain.enums.Authorize;
import domain.enums.InsuranceType;
import domain.enums.Treaty;
import java.io.File;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Insurance {

  @Id
  private String insuranceCode;

  private InsuranceType insuranceType;
  private File clauses;
  private String coverDescription;
  private int entryAge;
  private int interestRate;
  private String name;
  private int premium;
  private int premiumRate;
  private Authorize authorize;
  private Treaty treaty;
}
