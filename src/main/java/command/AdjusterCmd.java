package command;

import command.menu.AdjusterMenu;
import command.menu.YesOrNoMenu;
import command.parser.AdjusterParser;
import domain.Accident;
import domain.Adjust;
import domain.Dispatch;
import domain.enums.ProcessState;
import java.util.List;
import service.impl.AdjusterServiceImpl;

public class AdjusterCmd extends Command {

  private final static AdjusterParser adjusterParser = AdjusterParser.getInstance();
  private final static AdjusterServiceImpl adjusterService = new AdjusterServiceImpl();

  public static void run() {
    printTitle("면/부책 관리");
    executeCommand(AdjusterMenu.values());
  }

  public static void examine() {
    printTitle("면/부책 검토");
    System.out.println("처리할 사고를 선택해주세요.");
    List<Accident> accidentList = adjusterService.searchAccident(ProcessState.DISPATCH_COMPLETE);
    printTable(accidentList);

    Accident accident = accidentList.get(input());
    Dispatch dispatch = adjusterService.getDispatch(accident);

    printTitle("사고 현장 정보");
    printTable(dispatch);

    System.out.println("면/부책 검토를 진행하시겠습니까?");
    if (selectCommand(YesOrNoMenu.values()) == 0) {
      Adjust adjust = Adjust.builder()
          .indemnity(adjusterParser.getIndemnity())
          .basis(adjusterParser.getBasis())
          .accident(accident).build();
      adjusterService.registerAdjust(adjust);
      System.out.println("면/부책 검토가 완료되었습니다.");
    } else {
      System.out.println("면/부책 검토가 취소되었습니다.");
    }
    goHome();
  }

  public static void adjustDamage() {
    printTitle("손해사정");
  }
}
