package domain;

import domain.enums.AccidentType;
import domain.enums.VictimType;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
public class Accident {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @CreationTimestamp
  private LocalDate eventTime;

  private String eventLocation;
  private VictimType victim;

  @Enumerated(EnumType.STRING)
  private AccidentType accidentType;

  @ManyToOne
  @JoinColumn(name = "contract_id")
  private Contract contract;

  @Override
  public String toString() {
    return eventLocation;
  }
}
