package challenges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class GroceryListMain {
    // instantiate Scanner object as class attribute
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // instantiate groceryList as an ArrayList
        ArrayList<String> groceryList = new ArrayList<>();

        boolean programRunning = true;  // flag
        while (programRunning) {    // program loop
            int opted = askOption();    // fills "opted" with value returned by askOption()

            switch (opted) {    // self explained
                case 1 -> addItem(groceryList);
                case 2 -> removeItem(groceryList);
                default -> {
                    System.out.println("shutting down program...");
                    programRunning = false;
                }
            }

            groceryList.sort(Comparator.naturalOrder());    // sorts groceryList
            String currentItems = "current items: ";
            for (int i = 0; i < groceryList.size(); i++) {
                currentItems += groceryList.get(i) +
                        // if not the last index, concatenate with ","
                        ( (i < groceryList.size() - 1) ? ", " : "");
            }
            System.out.println(currentItems + "\n");    // print current items in groceryList
        }
    }

    public static int askOption() {
        System.out.println("""
            Options:
                0 -> shut down
                1 -> add item(s) to list, comma delimited list
                2 -> remove item(s) from list, comma delimited list"""
        );

        int opted;  // declare opted case as int
        do {
            System.out.print("Enter an option: ");
            opted = sc.nextInt();
        } while (opted < 0 || opted > 2);   // while option is in range [0, 2] (zero to two)
        sc.nextLine();  // this "eats" trailing newline left by nextInt()
        System.out.println();

        return opted;   // returns the int option case
    }

    public static void addItem(ArrayList<String> groceryList) {
        System.out.print("Insert item(s) to add: ");
        // reads answer and splits it with delimiter ","
        String[] items = (sc.nextLine()).split(",");

        // for every String "item" IN "items", put it into groceryList, don't forget to trim to prevent whitespaces
        for (String item : items) {
            // if the item does not exist in groceryList, add it
            if (!groceryList.contains(item.trim())) groceryList.add(item.trim());
        }
        System.out.println("[✓] " + Arrays.toString(items) + " has been added into the grocery list!");
    }

    public static void removeItem(ArrayList<String> groceryList) {
        System.out.print("Insert item(s) to remove: ");
        // reads answer and splits it with delimiter ","
        String[] items = (sc.nextLine()).split(",");

        // for every String "item" IN "items", remove from groceryList, don't forget to trim to prevent whitespaces
        for (String item : items) {
            if (groceryList.remove(item.trim()))    // remove() returns boolean, true if success
                System.out.println("[✓] removed: " + item.trim());
            else                                    // if remove() returns false
                System.out.println("[!] failed removing " + item.trim());
        }
    }
}
