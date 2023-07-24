package challenges;

public class NumberPalindrome {
    public static boolean isPalindrome(int number) {
        int original = number;
        int reversed = 0;

        while (number != 0) {
            reversed = (reversed * 10 + (number % 10));
            number /= 10;
        }

        return (reversed == original);
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(-222));
    }
}
