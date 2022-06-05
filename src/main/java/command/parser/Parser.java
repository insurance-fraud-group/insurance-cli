package command.parser;

import domain.enums.EmployeeType;
import domain.enums.InsuranceType;
import java.util.Arrays;
import java.util.Scanner;

public abstract class Parser {

  private static class ScannerHolder {

    private static final Scanner SCANNER = new Scanner(System.in);
  }

  public static Scanner getScanner() {
    return ScannerHolder.SCANNER;
  }

  protected Scanner sc;

  public Parser() {
    sc = getScanner();
  }

  public int validateInteger() {
    while (!sc.hasNextInt()) {
      sc.next();
      System.out.println("지정된 범위 내의 숫자를 입력해주세요.");
    }
    return sc.nextInt();
  }

  public int validateInteger(int start, int end) {
    int value = validateInteger();

    if (value < start || value > end) {
      value = validateInteger(start, end);
    }

    return value;
  }

  public InsuranceType getInsuranceType() {
    System.out.println("보험종류를 선택해주세요");
    Arrays.stream(InsuranceType.values()).forEach(type -> {
      System.out.println(
          Integer.toString(type.ordinal() + 1)
              .concat(". ")
              .concat(type.toString()));
    });

    System.out.print("보험종류 : ");

    int insuranceType = validateInteger();
    return (insuranceType < 1 || insuranceType > EmployeeType.values().length) ? getInsuranceType()
        : InsuranceType.values()[insuranceType - 1];
  }

  public abstract void initialize();
}
