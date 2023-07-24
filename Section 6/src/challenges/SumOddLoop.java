package challenges;

public class SumOddLoop {
    public static boolean isOdd(int number) {
        // number should only be positives, else: return false.
//        if (number % 2 != 0 && number > 0) return true;
//        else return false;
//        System.out.println(number + " is " + ((number % 2) != 0));
        return (number % 2 > 0);
    }

    public static int sumOdd(int start, int end) {
        if ((start < 1 || end < 1) || !(end >= start)) return -1;

        int sums = 0;
        for (int current = start; current <= end; current++) {
            if (isOdd(current)) sums += current;
        }
        return sums;
    }

    public static void main(String[] args) {
        System.out.println(isOdd(24));
        System.out.println(isOdd(-5));
    }
}
