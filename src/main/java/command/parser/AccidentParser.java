package command.parser;

import domain.enums.AccidentType;
import domain.enums.InsuranceType;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class AccidentParser extends Parser {


  private static class InstanceHolder {

    private static final AccidentParser INSTANCE = new AccidentParser();
  }

  private AccidentParser() {
    super();
  }

  public static AccidentParser getInstance() {
    return InstanceHolder.INSTANCE;
  }

  @Override
  public void initialize() {
    System.out.println("Accident");
  }

  public AccidentType getAccidentType() {
    System.out.println("사고종류를 선택해주세요");
    Arrays.stream(AccidentType.values()).forEach(type -> {
      System.out.println(
          Integer.toString(type.ordinal() + 1)
              .concat(". ")
              .concat(type.toString()));
    });

    System.out.print("사고종류 : ");
    while (!sc.hasNextInt()) {
      sc.next();
      System.out.println("Please enter a number within the range.");
    }

    int accidentType = sc.nextInt();
    return (accidentType < 1 || accidentType > AccidentType.values().length) ? getAccidentType()
        : AccidentType.values()[accidentType - 1];
  }

  public String getEventLocation() {
    System.out.print("사고 발생 위치 : ");
    return sc.next();
  }

  public boolean getVictim() {
    System.out.print("가해/피해 여부(true/false) : ");
    return sc.nextBoolean();
  }
}
