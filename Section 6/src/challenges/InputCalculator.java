package challenges;

import java.util.Scanner;

public class InputCalculator {
    public static void inputThenPrintSumAndAverage() {
        Scanner in = new Scanner(System.in);
        double sum = 0, count = 0;

        while (in.hasNextInt()) {
            sum += in.nextInt();
            count++;
        }
        System.out.println("SUM = " + (int) sum + " AVG = " + Math.round(sum / count));
    }

    public static void main(String[] args) {
        inputThenPrintSumAndAverage();
    }
}
