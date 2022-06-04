package command;

import command.menu.sales.SalesManagement;
import command.menu.underwriting.Underwriting;
import command.menu.underwriting.UnderwritingManagement;
import command.parser.UnderwritingParser;
import java.util.List;
import service.impl.UnderwritingServiceImpl;

public class UnderwritingCommand extends Command{

  private static final UnderwritingParser underwritingParser = UnderwritingParser.getInstance();
  private static final UnderwritingServiceImpl underwritingImpl = new UnderwritingServiceImpl();
  public static void run(){
    printMenu("인수심사", Underwriting.values());
  }

  public static void createAcceptancePolicy(){
    System.out.println("\n[인수정책 수립]");
    List<domain.Underwriting> underwritingList = underwritingImpl.createAcceptancePolicy();
    printTable(underwritingList);

    System.out.println("\n[인수정책을 수립해주세요]");


  }

  public static void underwrite(){



    printMenu("인수심사", UnderwritingManagement.values());
  }

  public static void manageCollaboration(){

  }

  public static void manageReinsurance(){

  }

  public static void manageLossRate(){

  }

}
