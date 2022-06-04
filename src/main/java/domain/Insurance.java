package domain;

import domain.enums.AuthorizeType;
import domain.enums.InsuranceType;
import domain.enums.Treaty;
import java.io.File;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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

  private File clauses;
  private String coverDescription;
  private int entryAge;
  private int interestRate;
  private String name;
  private int premium;
  private int premiumRate;

  @Enumerated(EnumType.STRING)
  private InsuranceType insuranceType;

  @Enumerated(EnumType.STRING)
  private AuthorizeType authorizeType;

  @Enumerated(EnumType.STRING)
  private Treaty treaty;

  @OneToMany
  private List<Contract> contractList;

  @Override
  public String toString() {
    return name;
  }
}
