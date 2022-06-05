package command;

import command.menu.CounselorMenu;

public class CounselorCmd extends Command {

  public static void run() {
    printTitle("상담");
    executeCommand(CounselorMenu.values());
  }

  public static void counsel() {
    printTitle("사고 접수 상담");
    System.out.println("피상담자의 정보를 입력해주세요");


  }

  public static void receiveAccident() {

  }

}
