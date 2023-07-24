package challenges;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ValidIntegersInputs {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = 0, sums = 0;

        while (count < 5) {
            System.out.print("Enter number #" + (count + 1) + ": ");
            try {
                sums += Integer.parseInt(in.nextLine());
                count++;
            } catch (NumberFormatException ignored) {
                System.out.println("Invalid Number");
            }
        }

        System.out.println("The sums of all valid integers is " + sums);
    }
}
