import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random randomizer = new Random();

        int[] originalArray = new int[5];
        for (int i = 0; i < originalArray.length - 1; i++) originalArray[i] = randomizer.nextInt(100);
        //int[] originalArray = {55, 55, 33, 43, 1};
        System.out.println(Arrays.toString(originalArray));
        System.out.println(Arrays.toString(sortDescending(originalArray, 1)));
    }

    public static int[] sortDescending(int[] a) { // bubble sort descending
        int temp;
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] < a[j]) { // < to descend, > to ascend
                    temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
        return a;
    }

    public static int[] sortDescending(int[] a, boolean type) { // insertion sort descending
        int temp, currInd;
        for(int i = 0; i < a.length; i++) {
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

    public static int[] sortDescending(int[] a, int unused) {
        int temp; boolean flag = true;
        while (flag) {
            flag = false;
            for (int i = 0; i < a.length - 1; i++) {
                if (a[i] < a[i + 1]) { // > to descend, < to ascend
                    temp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = temp;
                    flag = true;
                    System.out.println("----> " + Arrays.toString(a));
                }
            }
            System.out.println("--> " + Arrays.toString(a));
        }
        return a;
    }
}
