package domain;

import java.io.File;
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
public class Dispatch {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private int damage;
  private String accidentDescription;
  private File evidenceMedia;

  @OneToOne
  @JoinColumn(name = "accident_id")
  private Accident accident;

  @OneToOne
  @JoinColumn(name = "employee_id")
  private Employee accidentInvestigator;

  @Override
  public String toString() {
    return accidentDescription;
  }
}
