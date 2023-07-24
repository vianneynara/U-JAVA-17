package challenges;

public class LargestPrime {
    public static int getLargestPrime(int number) {
        //System.out.println("oofs");
        if (!(number < 2)) {
            for (int divisor = number / 2; divisor > 1; divisor--) {
                //System.out.print("A loop -> ");
                //System.out.print("number: " + number + ", divisor: " + divisor);
                if ((number % divisor) == 0) {
                    number = divisor;
                    //System.out.println(" (PRIME FOUND)");
                } //else System.out.println();
            }
            //System.out.println("Returning " + number);
            return number;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(getLargestPrime (-1));
        System.out.println(getLargestPrime (217));
    }
}
