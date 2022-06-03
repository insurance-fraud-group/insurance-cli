package command;

import command.menu.Menu;
import command.parser.Parser;
import java.util.Arrays;

public class Command {

  public static void print(String title, Menu[] menus) {
    System.out.println(title);

    Arrays.stream(menus).forEach(menu -> {
      System.out.println(
          Integer.toString(menu.ordinal() + 1)
              .concat(". ")
              .concat(menu.toString()));
    });

    System.out.print("> ");
    int selectedMenu = Parser.getScanner().nextInt();

    Arrays.stream(menus).forEach(menu -> {
      if (selectedMenu == menu.ordinal() + 1) {
        menu.execute();
      }
    });
  }
}
