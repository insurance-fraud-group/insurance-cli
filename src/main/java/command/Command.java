package command;

import command.menu.Menu;
import command.parser.Parser;
import dnl.utils.text.table.TextTable;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Command {

  public static int input() {
    System.out.print("> ");
    return Parser.getScanner().nextInt() - 1;
  }
  public static void printTitle(String title) {
    System.out.println("\n[" + title + "]");
  }

  public static void printMenu(String title, Menu[] menus) {
    printTitle(title);
    Arrays.stream(menus).forEach(menu -> System.out.println(
        Integer.toString(menu.ordinal() + 1)
            .concat(". ")
            .concat(menu.toString())));

    int selectedMenu = input();
    Arrays.stream(menus).forEach(menu -> {
      if (selectedMenu == menu.ordinal()) {
        menu.execute();
      }
    });
  }

  public static void printTable(List<?> list) {

    if (list.isEmpty()) {
      return;
    }

    TextTable tt = new TextTable(getTitle(list), getData(list));
    tt.printTable();
  }

  private static String[] getTitle(List<?> list) {
    Field[] fields = list.get(0).getClass().getDeclaredFields();
    String[] title = new String[fields.length];

    int i = 0;
    for (Field column : fields) {
      title[i++] = column.getName();
    }

    return title;
  }

  private static Object[][] getData(List<?> list) {
    Field[] fields = list.get(0).getClass().getDeclaredFields();
    Object[][] data = new Object[list.size()][fields.length];

    AtomicInteger rowId = new AtomicInteger();
    AtomicInteger columnId = new AtomicInteger();

    list.forEach(element -> {
      Arrays.stream(fields).forEach(field -> {
        try {
          field.setAccessible(true);
          data[rowId.get()][columnId.get()] = field.get(element);
          columnId.getAndIncrement();
        } catch (IllegalAccessException e) {
          throw new RuntimeException(e);
        }
      });
      columnId.set(0);
      rowId.getAndIncrement();
    });

    return data;
  }
}
