package challenges;

public class PrimeNumber {
    public static boolean isPrime(int number) {
        if (number <= 2) return (number == 2);

        for (int divisor = 2; divisor <= number / 2; divisor++) {
            if (number % divisor == 0) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println("11 is " + (isPrime(11) ? "" : "not ") + "a prime number");
        System.out.println("1 is " + (isPrime(1) ? "" : "not ") + "a prime number");
        System.out.println("2 is " + (isPrime(2) ? "" : "not ") + "a prime number");
        System.out.println("3 is " + (isPrime(3) ? "" : "not ") + "a prime number");
    }
}
