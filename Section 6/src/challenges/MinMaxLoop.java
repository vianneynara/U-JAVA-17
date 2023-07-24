package challenges;

import java.util.Scanner;

public class MinMaxLoop {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int minNumber = 0, maxNumber = 0, currentNumber, loopCounter = 0;

        do {
            System.out.print("Input a number: ");
            try {
                currentNumber = Integer.parseInt(in.nextLine());
                if ((currentNumber > maxNumber) || (loopCounter == 0)) maxNumber = currentNumber;
                if ((currentNumber < minNumber) || (loopCounter == 0)) minNumber = currentNumber;
                loopCounter++;
            } catch (NumberFormatException ignored) {
                if (loopCounter == 0) {
                    System.out.println();
                    System.out.println("No valid data entered");
                }
                else {
                    System.out.println();
                    System.out.println("Smallest number input: \t" + minNumber);
                    System.out.println("Biggest number input: \t" + maxNumber);
                }
                break;
            }
        } while (true);
    }
}
