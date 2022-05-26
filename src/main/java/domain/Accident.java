package domain;

import enums.AccidentType;
import java.awt.geom.Point2D;
import java.time.LocalDateTime;
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
public class Accident {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private Point2D.Double eventLocation;
  private LocalDateTime eventTime;
  private boolean victim;
  private AccidentType accidentType;

  @OneToOne
  @JoinColumn(name = "customer_id")
  private Customer customer;
}
