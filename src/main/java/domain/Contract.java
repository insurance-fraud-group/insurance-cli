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
public class Contract {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private boolean completion;
  private File subscription;

  @OneToOne
  @JoinColumn(name = "customer_id")
  private Customer customer;

  @OneToOne
  @JoinColumn(name = "product_id")
  private Product product;
}
