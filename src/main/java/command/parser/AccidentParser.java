package command.parser;

import domain.enums.AccidentType;
import domain.enums.VictimType;
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

    int accidentType = validateInteger(1, 5);
    return (accidentType < 1 || accidentType > AccidentType.values().length) ? getAccidentType()
        : AccidentType.values()[accidentType - 1];
  }

  public String getEventLocation() {
    System.out.print("사고 발생 위치 : ");
    return sc.next();
  }

  public VictimType getVictim() {
    System.out.print("가해/피해 여부(1/2) : ");
    return (validateInteger(1, 2) == 1) ? VictimType.ATTACKER : VictimType.VICTIM;
  }
}
