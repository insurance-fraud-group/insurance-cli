package command;

import command.menu.AccidentInvestigatorMenu;
import command.parser.AccidentInvestigatorParser;
import domain.Accident;
import domain.Dispatch;
import domain.enums.ProcessState;
import java.util.List;
import service.impl.AccidentInvestigatorServiceImpl;

public class AccidentInvestigatorCmd extends Command {

  private static final AccidentInvestigatorServiceImpl accidentInvestigatorService = new AccidentInvestigatorServiceImpl();
  private static final AccidentInvestigatorParser accidentinvestigatorparser = AccidentInvestigatorParser.getInstance();

  public static void run() {
    printTitle("사고 조사");
    executeCommand(AccidentInvestigatorMenu.values());
  }

  public static void receiveAccidentDispatch() {
    printTitle("사고 현장 출동 접수");
    System.out.println("사고 접수 리스트");
    List<Accident> accidentList = accidentInvestigatorService.searchAccident(ProcessState.REGISTERED);
    printTable(accidentList);
    System.out.println("출동 접수할 사고를 선택해주십시오");

    Accident accident = accidentList.get(input());
    System.out.println("선택한 사고에 대한 정보는 다음과 같습니다.");
    printTable(accident);

    System.out.println("해당 사고를 접수하시겠습니까?.");
    if (selectYesOrNo()) {
      accidentInvestigatorService.receiveDispatch(accident);
      System.out.println("사고 접수가 완료되었습니다.");
    } else {
      System.out.println("사고 접수가 취소되었습니다.");
    }
    goHome();
  }

  public static void processAccident() {
    printTitle("사고 현장 처리");
    List<Accident> accidentList = accidentInvestigatorService.searchAccident(ProcessState.DISPATCH_READY);
    printTable(accidentList);
    System.out.println("출동할 사고 현장을 선택해주세요.");
    Accident accident = accidentList.get(input());
    Dispatch dispatch = accidentInvestigatorService.getDispatch(accident);

    System.out.println("사고 현장 정보를 입력해주세요.");
    dispatch.setAccidentDescription(accidentinvestigatorparser.getAccidentDescription());
    dispatch.setDamage(accidentinvestigatorparser.getDamage());
    accidentInvestigatorService.processAccident(dispatch);
    System.out.println("사고 현장 처리가 완료되었습니다.");

    printTitle("현장 처리 정보");
    List<Dispatch> dispatchList = accidentInvestigatorService.searchDispatch();
    printTable(dispatchList);
    goHome();
  }
}
