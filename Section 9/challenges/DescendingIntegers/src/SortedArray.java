import java.util.Scanner;

public class SortedArray {

    public static int[] getIntegers(int size) {
        Scanner sc = new Scanner(System.in);
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = sc.nextInt();
        }
        return result;
    }

    public static int[] sortIntegers(int[] a) { // insertion sort descending
        int temp, currInd;

        for (int i = 0; i < a.length; i++) {
            currInd = i;
            while (currInd > 0 && a[currInd] > a[currInd - 1]) { // > to descend, < to ascend
                temp = a[currInd - 1];
                a[currInd - 1] = a[currInd];
                a[currInd] = temp;
                currInd--;
            }
        }

        return a;
    }

    public static void printArray(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.printf("Element %d contents %d%n", i, a[i]);
        }
    }
}
