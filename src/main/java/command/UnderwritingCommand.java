package command;

import command.menu.underwriting.UnderwritingMenu;
import command.menu.underwriting.UWManagement;
import command.parser.UnderwritingParser;
import domain.Underwriting;
import java.util.List;
import service.impl.UnderwritingServiceImpl;

public class UnderwritingCommand extends Command {

  private static final UnderwritingParser underwritingParser = UnderwritingParser.getInstance();
  private static final UnderwritingServiceImpl underwritingImpl = new UnderwritingServiceImpl();

  public static void run() {
    printMenu("인수심사", UnderwritingMenu.values());
  }


  public static void searchAcceptancePolicy() {
    System.out.println("\n[인수정책 조회]");
    List<Underwriting> underwritingList = underwritingImpl.searchAcceptancePolicy();
    printTable(underwritingList);
  }

  public static void createAcceptancePolicy() {
    System.out.println("\n[인수정책 수립]");
    System.out.println("\n[인수정책을 수립해주세요]");
    Underwriting input = Underwriting.builder()
        .name(underwritingParser.getName())
        .description(underwritingParser.getDescription())
        .build();
    underwritingImpl.createAcceptancePolicy(input);
    System.out.println("\n[인수정책 수립이 완료되었습니다]");

    System.out.println("\n[현재 수립된 인수정책 리스트]");
    List<Underwriting> underwritingList = underwritingImpl.searchAcceptancePolicy();
    printTable(underwritingList);

  }

  public static void underwrite() {

    printMenu("인수심사", UWManagement.values());
  }

  public static void manageCollaboration() {

  }

  public static void manageReinsurance() {

  }

  public static void manageLossRate() {

  }

}
