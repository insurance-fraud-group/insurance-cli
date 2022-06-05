package domain;

import domain.enums.TransactionType;
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

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private int amount;

  @Enumerated(EnumType.STRING)
  private TransactionType type;

  @ManyToOne
  @JoinColumn(name = "contract_id")
  private Contract contract;

  @Override
  public String toString() {
    return contract.toString() + " | " + amount + " " + type;
  }
}
