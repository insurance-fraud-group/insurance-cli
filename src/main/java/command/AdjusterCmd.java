package command;

import command.menu.AdjusterMenu;
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

  public static void examineIndemnity() {
    printTitle("면/부책 검토");
    System.out.println("처리할 사고를 선택해주세요.");
    List<Accident> accidentList = adjusterService.searchAccident(ProcessState.DISPATCH_COMPLETE);
    printTable(accidentList);

    Accident accident = accidentList.get(input());
    Dispatch dispatch = adjusterService.getDispatch(accident);

    printTitle("사고 현장 정보");
    printTable(dispatch);

    System.out.println("면/부책 검토를 진행하시겠습니까?");
    if (selectYesOrNo()) {
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
    System.out.println("손해사정을 진행할 항목을 선택해주세요.");
    List<Adjust> pendingAdjustList = adjusterService.searchPendingAdjust();
    printTable(pendingAdjustList);

    Adjust adjust = pendingAdjustList.get(input());
    printTable(adjust);
    System.out.println("손해사정을 정말 진행하시겠습니까?");

    if (selectYesOrNo()) {
      adjust.setPayment(adjusterParser.getPayment());
      adjusterService.updateAdjust(adjust);
      System.out.println("손해사정이 완료되었습니다.");
    } else {
      System.out.println("손해사정이 취소되었습니다.");
    }
    goHome();
  }

  public static void compensate() {
    printTitle("보상");
    System.out.println("보상을 진행할 항목을 선택해주세요.");
    List<Adjust> completedAdjustList = adjusterService.searchCompletedAdjust();
    printTable(completedAdjustList);

    Adjust adjust = completedAdjustList.get(input());
    printTable(adjust);
    System.out.println("보상을 정말 진행하시겠습니까?");

    if (selectYesOrNo()) {
      adjusterService.compensate(adjust);
      System.out.println("보상이 완료되었습니다.");
    } else {
      System.out.println("보상이 취소되었습니다.");
    }
    goHome();
  }
}
