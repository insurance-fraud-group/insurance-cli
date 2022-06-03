package command.parser;

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

  public abstract void initialize();
}
