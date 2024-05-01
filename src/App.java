import java.util.Random;
import java.util.Scanner;

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
    int[][] array2d = new int[100][3];
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
            case (one):
              System.out.println("How many items do you want to add");
              Scanner inputOne = new Scanner(System.in);
              if (inputOne.hasNextInt()) {
                noOfItems = inputOne.nextInt();
                insertItems(array2d, ITEM_COUNT, noOfItems);
                ITEM_COUNT += noOfItems;
              } else {
                System.out.println("Wrong input bitchies");
              }

              break;
            case (two):
              System.out.println("Specify item to remove");
              Scanner inputTwo = new Scanner(System.in);
              if (inputTwo.hasNextInt()) {
                int itemId = inputTwo.nextInt();
                removeItem(array2d, itemId);
              } else {
                System.out.println("Wrong input bitchies");
              }

              break;
            case (three):
              printItems(array2d);
              break;
            case (four):
              System.out.println("Enter item ID and number to be sold");
              Scanner inputThree = new Scanner(System.in);
              if (inputThree.hasNextInt()) {
                if (ITEM_ID) {
                  System.out.println("Cannot be found");
                  break;
                } else if (ITEM_ID) {
                  System.out.println("Failed to sell bc no space");
                } else {
                  System.out.println("Yaaaay, success");
                }
              } else {
                System.out.println("Wrong input bitchies");
              }
              break;
            case (five):
              System.out.println(
                "List with item number, count, total price and date modified"
              );
              break;
            case (six):
              System.out.println(
                "Sorted list with item number, count, total price and date modified"
              );
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

  public static boolean checkFull(final int[][] array2d, final int noOfItems) {
    for (int i = 0; i < array2d.length; i++) {
      if (array2d[i][0] == 0) {
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
      return index;
    }

    return -1;
  }
}
