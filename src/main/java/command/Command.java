package command;

import java.util.Scanner;

public abstract class Command {

  private static class ScannerHolder {

    private static final Scanner SCANNER = new Scanner(System.in);
  }

  public static Scanner getScanner() {
    return ScannerHolder.SCANNER;
  }

  protected Scanner sc;

  public Command() {
    sc = getScanner();
  }

  public abstract void initialize();
}
