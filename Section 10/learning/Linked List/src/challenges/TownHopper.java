package challenges;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

record Town(String name, int distance) {

    @Override
    public String toString() {
        return String.format("%s (%d km)", name, distance);
    }
}

public class TownHopper {

    private static final Scanner sc = new Scanner(System.in);
    private static LinkedList<Town> towns = new LinkedList<>(List.of(
            new Town("Adelaide", 1374),
            new Town("Alice Springs", 2771),
            new Town("Brisbane", 917),
            new Town("Darwin", 3972),
            new Town("Melbourne", 877),
            new Town("Perth", 3923)
    ));

    private static void divider() {
        System.out.println("\n" + "=".repeat(40));
    }

    private static void printMenu() {
        System.out.println("""
                Available actions (select word/letter):
                    (F)orward
                    (B)ackward
                    (L)ist Places
                    (M)enu
                    (Q)uit""");
    }

    private static int askOption() {
        String answer;
        while (true) {
            System.out.print("Option: ");
            answer = sc.nextLine().trim().toLowerCase();

            if (answer.equals("f") || answer.equals("forward"))
                return 1;
            else if (answer.equals("b") || answer.equals("backward"))
                return 2;
            else if (answer.equals("l") || "list places".contains(answer))
                return 3;
            else if (answer.equals("m") || answer.equals("menu"))
                return 4;
            else if (answer.equals("q") || answer.equals("quit"))
                return 5;
        }
    }

    public static void main(String[] args) {
        var iterator = towns.listIterator();
        boolean isRunning = true;

        while (isRunning) {
            divider();
            printMenu();
            switch (askOption()) {
                case 1 -> /* Forward */ {
                    System.out.println("Going forward to    : " + iterator.next().name());
                }
                case 2 -> /* Backward */ {
                    System.out.println("Going backward to   : " + iterator.previous().name());
                }
                case 3 -> /* List Places */ {
                    for (int i = 0; i < towns.size(); i++) {
                        System.out.print(towns.get(i) + ((i != towns.size() - 1) ? ", " : ""));
                    }
                }
                case 5 -> /* Quit */ {
                    System.out.println("Exiting program...");
                    isRunning = false;
                }
            }
        }
    }
}
