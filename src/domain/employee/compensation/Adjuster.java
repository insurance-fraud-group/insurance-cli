package domain.employee.compensation;

import domain.Dispatch;

public class Adjuster extends Compensation {

  public Adjuster() {

  }

  public int calculateDamage() {
    return 0;
  }

  public int calculatePremium(int damage) {
    return 0;
  }

  public boolean judge(Dispatch dispatch) {
    return false;
  }
}
