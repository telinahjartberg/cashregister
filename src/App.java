import java.util.*;

public class App {

  public static final int one = 1;
  public static final int two = 2;
  public static final int three = 3;
  public static final int four = 4;
  public static final int five = 5;
  public static final int six = 6;
  public static final int quit = -1;
  public static final boolean ITEM_ID = true;

  public static final int ITEM_NUMBER = 0;

  public static int ITEM_COUNT = 999;

  public static void main(String[] args) throws Exception {
    int noOfItems = 0;
    int[] array = new int[5];
    int[][] items = new int[100][3];
    int[][] sales = new int[100][3];
    Date[] salesDate = new Date[100];
    while (true) {
      System.out.println("1. Insert items");
      System.out.println("2. Remove items");
      System.out.println("3. Display a list of items");
      System.out.println("4. Register a sale");
      System.out.println("5.Display sales history");
      System.out.println("6. Sort and display sales history");
      System.out.println("q. Quit");
      System.out.println("Your selection: ");

      Scanner scanner = new Scanner(System.in);

      if (scanner.hasNextInt()) {
        int input = scanner.nextInt();
        if (input >= 1 && input <= 6) {
          switch (input) {
            case one:
              System.out.println("How many items do you want to add");
              Scanner inputOne = new Scanner(System.in);
              if (inputOne.hasNextInt()) {
                noOfItems = inputOne.nextInt();
                insertItems(items, ITEM_COUNT, noOfItems);
                ITEM_COUNT += noOfItems;
              } else {
                System.out.println("Wrong input bitchies");
              }

              break;
            case two:
              System.out.println("Specify item to remove");
              Scanner inputTwo = new Scanner(System.in);
              if (inputTwo.hasNextInt()) {
                int itemId = inputTwo.nextInt();
                removeItem(items, itemId);
              } else {
                System.out.println("Wrong input bitchies");
              }

              break;
            case three:
              printItems(items);
              break;
            case four:
              System.out.println("Enter item ID and number to be sold");
              Scanner inputFour = new Scanner(System.in);
              if (inputFour.hasNextInt()) {
                int itemId = inputFour.nextInt();
                if (inputFour.hasNextInt()) {
                  int amount = inputFour.nextInt();
                  sellItem(sales, salesDate, items, itemId, amount);
                } else {
                  System.out.println("Wrong input");
                }
              } else {
                System.out.println("Wrong input bitchies");
              }
              break;
            case five:
              printSales(sales, salesDate);
              break;
            case six:
              sortedTable(sales, salesDate);
              break;
          }
        } else {
          System.out.println(" input is invalid. Try again");
          return;
        }
      } else if (scanner.hasNextLine()) {
        String input = scanner.nextLine();
        if (input.equals("q")) {
          System.out.println("Terminating...");
          System.exit(0);
        } else {
          System.out.println("Sorry, input is invalid. Try again");
          return;
        }
      }
    }
  }

  public static int[][] insertItems(
    final int[][] items,
    final int lastItemId,
    final int noOfItems
  ) {
    int last_num = lastItemId - 999; // get the last item number
    for (int i = last_num; i < last_num + noOfItems; i++) {
      if (items[i][0] == 0) {
        items[i][0] = 1000 + i; // item number
        items[i][1] = new Random().nextInt(10); // item count
        items[i][2] = new Random().nextInt(1000); // item price
      }
    }
    System.out.println(noOfItems + " items added");
    return items;
  }

  public static void printItems(final int[][] items) {
    System.out.println("Item number  Count  Price");
    for (int i = 0; i < items.length; i++) {
      if (items[i][0] != 0) {
        System.out.print(items[i][0] + "   ");
        System.out.print(items[i][1] + "   ");
        System.out.print(items[i][2]);
        System.out.println();
      }
    }
  }

  public static boolean checkFull(final int[][] items, final int noOfItems) {
    for (int i = 0; i < items.length; i++) {
      if (items[i][0] == 0) {
        return true;
      }
    }
    return false;
  }

  public static int removeItem(final int[][] items, final int itemId) {
    int index = itemId - 1000; // get the index of the item
    if (items[index][0] != 0) { // check if item exists
      items[index][0] = 0;
      items[index][1] = 0;
      items[index][2] = 0;
      System.out.println("Successfully removed item " + itemId);
      return index;
    } else {
      System.out.println("Could not find item " + itemId);
    }

    return -1;
  }

  public static int sellItem(
    final int[][] sales,
    final Date[] salesDate,
    final int[][] items,
    final int itemIdToSell,
    final int amountToSell
  ) {
    int index = itemIdToSell - 1000;
    if (items[index][0] == itemIdToSell) {
      if (items[index][1] >= amountToSell) {
        items[index][1] -= amountToSell; // update item count
        for (int i = 0; i < sales.length; i++) {
          if (sales[i][0] == 0) {
            sales[i][0] = itemIdToSell; // item number
            sales[i][1] = amountToSell; // item count
            sales[i][2] = items[index][2] * amountToSell; // total price
            salesDate[i] = new Date(); // date modified
            break;
          }
        }

        System.out.println(
          "Sold " + amountToSell + " units of item " + itemIdToSell
        );
      } else {
        System.out.println(
          "failed to sell specified amount, only " +
          items[index][1] +
          " units are available"
        );
      }
    } else {
      System.out.println("Could not find item " + itemIdToSell);
    }

    return 0;
  }

  public static void printSales(final int[][] sales, final Date[] salesDate) {
    for (int i = 0; i < sales.length; i++) {
      if (sales[i][0] != 0) {
        System.out.print(sales[i][0] + "    ");
        System.out.print(sales[i][1] + "    ");
        System.out.print(sales[i][2] + "    ");
        System.out.print(salesDate[i]);
        System.out.println();
      }
    }
  }

  public static void sortedTable(final int[][] sales, final Date[] salesDate) {
    //bubble sort
    for (int i = 0; i < sales.length; i++) {
      for (int j = 0; j < sales.length - i - 1; j++) {
        if (sales[j][0] > sales[j + 1][0]) {
          int temp = sales[j][0];
          sales[j][0] = sales[j + 1][0];
          sales[j + 1][0] = temp;
          Date tempDate = salesDate[j];
          salesDate[j] = salesDate[j + 1];
          salesDate[j + 1] = tempDate;
        }
      }
    }
  }
}
