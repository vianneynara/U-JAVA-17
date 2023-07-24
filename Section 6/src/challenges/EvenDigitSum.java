package challenges;

public class EvenDigitSum {
    public static int getEvenDigitSum(int number) {
        if (number < 0) return -1;

//        int sumOfEvenDigits = 0, currentDigit;
//        while (number != 0) {
//            currentDigit = number % 10;
//            if (currentDigit % 2 == 0) sumOfEvenDigits += currentDigit;
//            number /= 10;
//        }

        int sumOfEvenDigits = 0;
        while (number != 0) {
            if (number % 2 == 0) sumOfEvenDigits += number % 10;
            number /= 10;
        }

        return sumOfEvenDigits;
    }

    public static void main(String[] args) {
        System.out.println(getEvenDigitSum(123456789));
    }
}
