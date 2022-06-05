package command;

import command.menu.AuthMenu;
import command.menu.CustomerServiceMenu;
import command.menu.Menu;
import command.menu.YesOrNoMenu;
import command.menu.sales.Sales;
import command.menu.underwriting.UnderwritingMenu;
import command.parser.Parser;
import dnl.utils.text.table.TextTable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Command {

  private static List<Class<?>> mainMenus = List.of(
      new Class[]{UnderwritingMenu.class, Sales.class, CustomerServiceMenu.class});

  public static int input() {
    System.out.print("> ");
    return Parser.getScanner().nextInt() - 1;
  }

  public static void printTitle(String title) {
    System.out.println("\n[" + title + "]");
  }

  public static void executeCommand(Menu[] menus) {
    int selectedMenu = selectCommand(menus);
    Class<?> menuClass = menus[0].getClass();

    if (selectedMenu == menus.length) {
      if (mainMenus.contains(menuClass)) {
        AuthCmd.exit();
      }
      AuthCmd.initialize();
    }
    Arrays.stream(menus).forEach(menu -> {
      if (selectedMenu == menu.ordinal()) {
        menu.execute();
      }
    });
  }

  public static int selectCommand(Menu[] menus) {
    printMenu(menus);
    printExitMenu(menus);

    return input();
  }

  public static boolean selectYesOrNo() {
    Menu[] menus = YesOrNoMenu.values();
    printMenu(menus);
    printExitMenu(menus);

    return input() == 0;
  }

  private static void printMenu(Menu[] menus) {
    Arrays.stream(menus).forEach(menu -> System.out.println(
        Integer.toString(menu.ordinal() + 1).concat(". ").concat(menu.toString())));
  }

  private static void printExitMenu(Menu[] menus) {
    int last = menus.length + 1;
    Class<?> menuClass = menus[0].getClass();

    String lastCommand = menuClass.equals(AuthMenu.class) ? "종료"
        : (mainMenus.contains(menuClass) ? "로그아웃" : "메인으로 돌아가기");
    System.out.println(last + ". " + lastCommand);
  }

  public static void printTable(List<?> list) {
    if (list.isEmpty()) {
      System.out.println("데이터를 가져오지 못했습니다. 관리자에게 문의하세요.");
      AuthCmd.initialize();
    }

    TextTable tt = new TextTable(getTitle(list), getData(list));
    tt.printTable();
  }

  public static void printTable(List<?> list, String... args) {
    if (list.isEmpty()) {
      System.out.println("데이터를 가져오지 못했습니다. 관리자에게 문의하세요.");
      AuthCmd.initialize();
    }

    TextTable tt = new TextTable(args, getData(list, args));
    tt.printTable();
  }

  public static void printTable(Object object) {
    List<Object> list = new ArrayList<>();
    list.add(object);
    printTable(list);
  }

  public static void printTable(Object object, String... args) {
    List<Object> list = new ArrayList<>();
    list.add(object);
    printTable(list, args);
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

  private static String[][] getData(List<?> list) {
    Field[] fields = list.get(0).getClass().getDeclaredFields();
    String[][] data = new String[list.size()][fields.length];

    AtomicInteger rowId = new AtomicInteger();
    AtomicInteger columnId = new AtomicInteger();

    list.forEach(element -> {
      Arrays.stream(fields).forEach(field -> {
        try {
          field.setAccessible(true);
          data[rowId.get()][columnId.get()] =
              field.get(element) == null ? "" : field.get(element).toString();
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

  private static String[][] getData(List<?> list, String... args) {
    String[][] data = new String[list.size()][args.length];

    AtomicInteger rowId = new AtomicInteger();
    AtomicInteger columnId = new AtomicInteger();

    list.forEach(element -> {
      Arrays.stream(args).forEach(arg -> {
        try {
          Field field = element.getClass().getDeclaredField(arg);
          field.setAccessible(true);
          data[rowId.get()][columnId.get()] =
              field.get(element) == null ? "" : field.get(element).toString();
          columnId.getAndIncrement();
        } catch (Exception e) {
          throw new RuntimeException(e);
        }
      });
      columnId.set(0);
      rowId.getAndIncrement();
    });
    return data;
  }
}
