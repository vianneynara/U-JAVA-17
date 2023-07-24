package challenges;

public class GreatestCommonDivisor {
    public static int getGreatestCommonDivisor(int first, int second) {
        if ((first < 10) || (second < 10)) return -1;

        int greatestCommonDivisor = 1;
        for (int i = 1; (i < first) || (i < second); i++) {
            if ((first % i == 0) && (second % i == 0)) greatestCommonDivisor = i;
        }

        return greatestCommonDivisor;

        // using Euclidean algorithm
//        while (first != second) {
//            if (first > second) first -= second;
//            else second -= first;
//        }
//
//        return second;
    }

    public static void main(String[] args) {
        System.out.println(getGreatestCommonDivisor(12, 30));
        System.out.println(getGreatestCommonDivisor(81, 153));
    }
}
