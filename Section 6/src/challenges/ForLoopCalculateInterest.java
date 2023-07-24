package challenges;

public class ForLoopCalculateInterest {
    public static double calculateInterest(double amount, double interestRate) {
        return (amount * (interestRate / 100));
    }
    public static void main(String[] args) {
        int amount = 10000;
        for (double interestRate = 7.5; interestRate <= 10; interestRate += 0.25) {
            if (interestRate > 8.5) break;
            System.out.println(interestRate + "% interest of $" + amount + " is $" + calculateInterest(amount, interestRate));
        }
    }
}
