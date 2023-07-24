package challenges;

public class DigitSum {
    public static int sumDigits(int number) {
        if (number < 0) return -1;

        int sums = 0;
        while (number > 9) {
            sums += (number % 10);
            number /= 10;
            System.out.println("sums: " + sums + ", remaining numbers: " + number);
        }
        sums += number;

        return sums;
    }

    public static void main(String[] args) {
        System.out.println("Summed number: " + sumDigits(235234));
    }
}
