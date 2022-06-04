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
public class Adjust {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private String basis;
  private boolean indemnity;
  private int payment;

  @OneToOne
  @JoinColumn(name = "accident_id")
  private Accident accident;

  @Override
  public String toString() {
    return basis;
  }
}
