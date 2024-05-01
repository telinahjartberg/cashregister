import java.util.Scanner;

public class App {

  public static void main(String[] args) throws Exception {
    while (true) {
      System.out.println("1. Insert items");
      System.out.println("2. Remove an item");
      System.out.println("3. Display a list of items");
      System.out.println("4. Register a sale");
      System.out.println("5. Display sales history");
      System.out.println("6. Sort and display sales table");
      System.out.println("q. Quit");

      while (true) {
        System.out.println("Your selection: ");
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextLine()) {
          String selection = scanner.nextLine();
          switch (selection) {
            case "q":
              System.out.println("Goodbye!");
              return;
            case "1":
              scanner = new Scanner(System.in);
              insertItems(scanner);
              break;
            case "2":
              System.out.println("Remove an item");
              break;
            case "3":
              System.out.println("Display a list of items");
              break;
            default:
              System.out.println("Invalid selection");
          }
        }
      }
    }
  }

  public static void insertItems(Scanner scanner) {
    System.out.println("Insert items");
    String selection2 = scanner.nextLine();
    System.out.println(selection2 + " items added");
  }
}
