package challenges;

public class PerfectNumber {
    public static boolean isPerfectNumber(int number) {
        // more optimized code
        int sums = 0;
        int incrementer = (number % 2 == 0) ? 1 : 2;

        for (int divisor = 1; divisor <= number / 2; divisor += incrementer) {
            if (number % divisor == 0) sums += divisor;
        }

        return ((sums == number) && (number > 1));

//        if (number < 1) return false;

//        int sums = 0, divisor = 1;
//        while (divisor < number) {
//            sums += (number % divisor == 0) ? divisor : 0;
//            divisor++;
//        }

//        int sums = 0;
//        for (int divisor = 1; divisor < number; divisor++) {
//            if (number % divisor == 0) sums += divisor;
//        }

        // System.out.println("sums: " + sums + ", number: " + number);
        // return (sums == number);
    }

    public static void main(String[] args) {
        System.out.println(isPerfectNumber(5));
        System.out.println(isPerfectNumber(33550336));
    }
}
