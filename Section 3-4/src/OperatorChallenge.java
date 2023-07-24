package Section4;

public class OperatorChallenge {
    public static void main(String[] args) {
        double num1 = 20.00D;
        double num2 = 80.00D;
        double sums = (num1 + num2) * 100.00D;
        System.out.println("sums => " + sums);

        double rem = sums % 40.00D;
        System.out.println("rem  => " + rem);

        boolean isZero = (rem == 0.00D);
        System.out.println("has no remainder => " + isZero);

        if (!isZero) {
            System.out.println("got some remainder");
        }
    }
}
