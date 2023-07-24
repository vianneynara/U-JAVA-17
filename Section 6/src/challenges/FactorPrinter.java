package challenges;

public class FactorPrinter {
    public static void printFactors(int number) {
        if (number < 1) {
            System.out.println("Invalid Value");
        }
        else {
            int divider = 1;
            while (!(divider > number)) {
                if (number % divider == 0) System.out.print(divider + " ");
                divider++;
            }

            //for (int divider = 1; divider <= number; divider++) {
            //    if (number % divider == 0) System.out.print(divider + " ");
            //}
        }
    }

    public static void main(String[] args) {
        printFactors(32);
    }
}
