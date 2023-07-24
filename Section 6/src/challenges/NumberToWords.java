package challenges;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class NumberToWords {
    public static void numberToWords(int number) {
        if (number < 0) {
            System.out.println("Invalid Value");
            return;
        }

        int currentDigit, digitCount = getDigitCount(number);
        number = reverse(number);

        while (digitCount != 0) {
            currentDigit = number % 10;
            switch (currentDigit) {
                case 1: System.out.print("One "); break;
                case 2: System.out.print("Two "); break;
                case 3: System.out.print("Three "); break;
                case 4: System.out.print("Four "); break;
                case 5: System.out.print("Five "); break;
                case 6: System.out.print("Six "); break;
                case 7: System.out.print("Seven "); break;
                case 8: System.out.print("Eight "); break;
                case 9: System.out.print("Nine "); break;
                default: System.out.print("Zero ");
            }
            number /= 10;
            digitCount--;
        }
    }

    public static int reverse(int number) {
        int reversed = 0;
        while (number != 0) {
            reversed = (reversed * 10) + (number % 10);
            number /= 10;
        }
        return reversed;
    }

    public static int getDigitCount(int number) {
        if (number < 0) return -1;

        int digitCount = 1;
        while (number > 9) {
            digitCount++;
            number /= 10;
        }
        return digitCount;
    }

    public static void main(String[] args) {
        numberToWords(1000);
        System.out.println(reverse(1234));
        System.out.println(getDigitCount(0));
    }
}
