package domain;

import java.util.Date;
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
public class AcceptancePolicy {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private Date createdDate;
  private String description;
  private String name;

  @OneToOne
  @JoinColumn(name = "employee_id")
  private Employee writer;
}
