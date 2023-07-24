package challenges;

public class PrimeNumberLooping {
    public static boolean isPrime(int number) {
        if (number <= 2) return (number == 2);

        for (int divisor = 2; divisor <= number / 2; divisor++) {
            if (number % divisor == 0) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        int primeCounter = 0;

        for (int number = 678; number <= 1000 && primeCounter < 3; number++) {
            if (isPrime(number)) {
                System.out.println(number + " is prime!");
                primeCounter++;
            }
            if (primeCounter == 3) {
                System.out.println("Found 3 prime numbers.");
                // break;
            }
        }
    }
}
