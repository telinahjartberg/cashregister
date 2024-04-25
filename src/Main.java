import java.util.Date;
import java.util.Scanner;

/**
 * Describe briefly your program in steps.
 *
 @author Telina Hjärtberg (telhjr-4)
 */
public class Main {

  // Constants for the item array
  public static final int ITEM_ID = 0;
  public static final int ITEM_COUNT = 1;
  public static final int ITEM_PRICE = 2;
  public static final int ITEM_COLUMN_SIZE = 3;
  public static final int INITIAL_ITEM_SIZE = 10;

  // Constants for the sales array
  public static final int SALE_ITEM_ID = 0;
  public static final int SALE_ITEM_COUNT = 1;
  public static final int SALE_ITEM_PRICE = 2;
  public static final int SALE_COLUMN_SIZE = 3;
  public static final int MAX_SALES = 1000;

  // Other constants
  public static final int MENU_ITEM_1 = 1;
  public static final int MENU_ITEM_2 = 2;
  public static final int MENU_ITEM_3 = 3;
  public static final int MENU_ITEM_4 = 4;
  public static final int MENU_ITEM_5 = 5;
  public static final int MENU_ITEM_6 = 6;
  public static final int MENU_ITEM_Q = -1;

  public static final int INITIAL_ITEM_NUMBER = 999;

  public static final String errorMessage =
    "Invalid selection. Only number between 1-6 or q are allowed!";

  private static Scanner userInputScanner = new Scanner(System.in);

  /**
   * This method should be used only for unit testing on CodeGrade. Do not change this method!
   * Swaps userInputScanner with a custom scanner object bound to a test input stream
   *
   * @param inputScanner  test scanner object
   */
  public static void injectInput(final Scanner inputScanner) {
    userInputScanner = inputScanner;
  }

  public static void main(final String args[]) {
    int[][] items = new int[INITIAL_ITEM_SIZE][ITEM_COLUMN_SIZE]; // Data structure to store items
    int[][] sales = new int[MAX_SALES][SALE_COLUMN_SIZE]; // Data structure to store sales
    Date[] saleDates = new Date[MAX_SALES]; // Data structure to store sale dates
    int lastItemNumber = INITIAL_ITEM_NUMBER; // Keep track of last added ItemNumber
    System.out.println("This is Marked Assignment 4");
    while (true) {
      int userSelection = menu();
      switch (userSelection) {
        case MENU_ITEM_1:
          System.out.println("Enter how many items you want to add: ");
          int nrOfItems = input();
          items = insertItems(items, lastItemNumber, nrOfItems);
          lastItemNumber = lastItemNumber + nrOfItems;
          System.out.println(nrOfItems + " items were added.");
          break;
        case MENU_ITEM_2:
          // ask user how many items to remove
          // call removeItem
          break;
        case MENU_ITEM_3:
          break;
        case MENU_ITEM_4:
          // ask user for itemsID and noOFfItems
          // call sellItem
          // check for different return values and print appropriate messages
          break;
        case MENU_ITEM_5:
          // print
          break;
        case MENU_ITEM_6:
          // use bubble sort
          break;
        case MENU_ITEM_Q:
          System.out.println("Terminating...");
          return;
        default:
          System.out.println("Oops");
      }
    }
  }

  public static int menu() {
    System.out.println("1. Insert items");
    System.out.println("2. Remove an item");
    System.out.println("3. Display a list of items");
    System.out.println("4. Register a sale");
    System.out.println("5. Display sales history");
    System.out.println("6. Sort and display sales table");
    System.out.println("q. Quit");
    System.out.println("Your selection: ");
    return (input()); // Will do method called input to fit here
  }

  public static int input() {
    int userInput = 0;
    Scanner scanner = new Scanner(System.in);
    userInput = scanner.nextInt();
    // if (scanner.hasNextInt()) {
    //     userInput = scanner.nextInt();
    //     if (userInput >= 1 && userInput <= 6) {
    //         // System.out.println(menu());
    //     } else {
    //     System.out.println(errorMessage);
    //     }
    // } else {
    //     String input = scanner.nextLine();
    //     if (input.equals("q")) {
    //         System.exit(0);
    //     } else {
    //         System.out.println(errorMessage);
    //     }
    // }

    return userInput;
  }

  public static int[][] insertItems(
    final int[][] items,
    final int lastItemId,
    final int noOfItems
  ) {
    int newItemNr = lastItemId + 1;
    int[][] workingArray = items;
    // call the checkitem method
    // check if array or will be full when all items are added
    if (checkFull(items, noOfItems)) {
      workingArray = extendArray(items, noOfItems);
    }
    // new items to be added
    // populate the values
    int lastItem = getActualSize(workingArray);

    for (int i = lastItem; i < lastItem + noOfItems; i++) {
      workingArray[i][ITEM_ID] = newItemNr++;
      workingArray[i][ITEM_COUNT] = 5; // should be random
      workingArray[i][ITEM_PRICE] = 140; // should be random
    }
    return new int[][] {};
  }

  public static boolean checkFull(final int[][] items, final int noOfItems) {
    // calculate current items actual size
    // sum the number of rows that are 0
    // freeslots <= nrOfItems return true

    // use getFreeSlots
    return false;
  }

  //alt for checkfull
  public static int getFreeSlots(final int[][] items) {
    int count = 0;
    for (int i = 0; i < items.length; i++) {
      if (items[i][ITEM_ID] == 0) {
        count++;
      }
    }
    return 1;
  }

  public static int[][] extendArray(final int[][] items, final int noOfItems) {
    int[][] newItems = new int[items.length + noOfItems][ITEM_COLUMN_SIZE];
    // copy items into newItems
    return newItems;
  }

  public static int removeItem(final int[][] items, final int itemId) {
    // validate if itemID exists
    // sum the number of rows that are 0
    return -1;
  }

  public static int getActualSize(int[][] items) {
    int count = 0;
    for (int i = 0; i < items.length; i++) {
      if (items[i][0] != 0) {
        count++;
      }
    }
    return 1;
  }

  public static void sortedTable(final int[][] sales, final Date[] salesDate) {}
}
