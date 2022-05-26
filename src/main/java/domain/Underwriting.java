package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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
public class Underwriting {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private int environmentalFactorScore;
  private int financialFactorScore;
  private int moralFactorScore;
  private int physicalFactorScore;

  @OneToOne
  @JoinColumn(name = "insurance_id")
  private Insurance insurance;

  @OneToOne
  @JoinColumn(name = "customer_id")
  private Customer customer;
}
