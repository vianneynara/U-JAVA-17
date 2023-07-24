package challenges;

public class OnlyEvenNumbersLoop {
    public static boolean isEvenNumber(int number) {
        return (number % 2 == 0);
    }

    public static void main(String[] args) {
        int evenNumbersCount = 0;
        int oddNumbersCount = 0;
        int number = 4;
        int end = 20;

        while ( (number <= end) ) {
            if (isEvenNumber(number)) {
                System.out.println(number);
                evenNumbersCount++;
            }
            else oddNumbersCount++;

            number++;
            if(evenNumbersCount < 5) break;
        }

        System.out.println("There are " + evenNumbersCount + " even numbers");
        System.out.println("There are " + oddNumbersCount + " odd numbers");
    }
}
