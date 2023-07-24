package challenges;

public class Sum3And5 {
    public static void main(String[] args) {
         int sumsOfAllFoundNumbers = 0;
         int numberFoundCounter = 0;

         for (int number = 534; number < 1000 && numberFoundCounter < 5; number++) {
             if ((number % 3 == 0) && (number % 5 == 0)) {
                 System.out.println(number + " is divisible by 3 and 5.");
                 numberFoundCounter++;
                 sumsOfAllFoundNumbers += number;
             }
         }

        System.out.println("Sums of the numbers found is " + sumsOfAllFoundNumbers);
    }
}
