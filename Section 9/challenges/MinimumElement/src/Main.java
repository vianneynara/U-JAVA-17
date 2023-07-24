import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] numbers = readIntegers();
        System.out.println(findMin(numbers));

        int[] randomInts = randomArrayInt(10);
        System.out.println(Arrays.toString(randomInts));
        System.out.println(findMin(randomInts));
    }

    private static int[] readIntegers() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter numbers separated by comma: ");
        String[] raw = sc.nextLine().split(",");
        int[] numbers = new int[raw.length];
        for(int i = 0; i < raw.length; i++) {
            numbers[i] = Integer.parseInt(raw[i].trim());
        }
        return numbers;
    }

    private static int findMin(int[] array) {
        int smallest = Integer.MAX_VALUE;
        for (int num : array) {
            if (num < smallest) smallest = num;
        }
        return smallest;
    }

    private static int[] randomArrayInt(int amount) {
        Random random = new Random();
        int[] numbers = new int[amount];
        for (int i = 0; i < amount; i++) {
            numbers[i] = random.nextInt(100);
        }
        return numbers;
    }
}
