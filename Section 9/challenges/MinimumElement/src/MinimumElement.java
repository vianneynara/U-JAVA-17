import java.util.Scanner;

public class MinimumElement {

    private static int readInteger() {
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    private static int[] readElements(int repeats) {
        Scanner sc = new Scanner(System.in);
        int[] result = new int[repeats];
        for (int i = 0; i < repeats; i++) {
            result[i] = sc.nextInt();
        }
        return result;
    }

    private static int findMin(int[] a) {
        int smallest = Integer.MAX_VALUE;
        for (int num : a) {
            if (num < smallest) {
                smallest = num;
            }
        }
        return smallest;
    }
}