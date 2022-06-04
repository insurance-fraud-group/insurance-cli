package command;

import command.menu.UnderwritingMenu;
import command.parser.UnderwritingParser;
import domain.Underwriting;
import java.util.List;
import service.impl.UnderwritingServiceImpl;

public class UnderwritingCommand extends Command{

  private static final UnderwritingParser underwritingParser = UnderwritingParser.getInstance();
  private static final UnderwritingServiceImpl underwritingImpl = new UnderwritingServiceImpl();
  public static void run(){
    printMenu("인수심사", UnderwritingMenu.values());
  }

  public static void createAcceptancePolicy(){
    System.out.println("\n[인수정책 수립]");
    List<Underwriting> underwritingList = underwritingImpl.createAcceptancePolicy();
    printTable(underwritingList);


  }

  public static void underwrite(){

  }

  public static void manageCollaboration(){

  }

  public static void manageReinsurance(){

  }

  public static void manageLossRate(){

  }

}
