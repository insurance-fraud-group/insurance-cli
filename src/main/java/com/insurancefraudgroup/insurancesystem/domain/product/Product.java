package com.insurancefraudgroup.insurancesystem.domain.product;

import com.insurancefraudgroup.insurancesystem.enums.Authorize;
import com.insurancefraudgroup.insurancesystem.enums.Treaty;
import java.io.File;

public class Product {

  private String productCode;
  private File clauses;
  private String coverDescription;
  private int entryAge;
  private int interestRate;
  private String name;
  private int premium;
  private int premiumRate;
  private Authorize authorize;
  private Treaty treaty;

  public Product() {

  }
}
