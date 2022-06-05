package domain;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
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

  @CreationTimestamp
  private LocalDate date;

  private boolean signed;

  private int environmentalFactorScore;
  private int financialFactorScore;
  private int moralFactorScore;
  private int physicalFactorScore;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User writer;

  @OneToOne
  @JoinColumn(name = "contract_id")
  private Contract contract;

  @Override
  public String toString() {
    return writer.toString() + "'s " + contract.toString();
  }
}
