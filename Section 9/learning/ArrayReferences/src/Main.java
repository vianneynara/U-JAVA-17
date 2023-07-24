import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] myIntArray = new int[5]; // reference
        int[] anotherArr = myIntArray;
        int[] differentA = Arrays.copyOf(anotherArr, anotherArr.length);

        System.out.println(Arrays.toString(myIntArray));
        System.out.println(Arrays.toString(anotherArr));

        anotherArr[0] = 1;
        modifyArray(differentA);

        System.out.println("after change anotherArr: " + Arrays.toString(anotherArr));
        System.out.println("after change myIntArray: " + Arrays.toString(myIntArray));
        System.out.println("after change differentA: " + Arrays.toString(differentA));

        // they are the same because they are referencing the same address in memory
    }

    private static void modifyArray(int[] a) {
        a[1] = 2;
    }
}
