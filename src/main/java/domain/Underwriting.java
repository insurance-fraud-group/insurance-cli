package domain;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

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

  private String name;
  private String description;

  @CreationTimestamp
  private LocalDate date;

  private String supplier;
  private int environmentalFactorScore;
  private int financialFactorScore;
  private int moralFactorScore;
  private int physicalFactorScore;

  @ManyToOne
  @JoinColumn(name = "employee_id")
  private Employee writer;

  @ManyToOne
  @JoinColumn(name = "insurance_id")
  private Insurance insurance;

  @ManyToOne
  @JoinColumn(name = "customer_id")
  private Customer customer;

  @Override
  public String toString() {
    return name;
  }
}
