import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arrays = {1, 22, 45, 33};
        System.out.println(Arrays.toString(arrays));
        reverse(arrays);
        System.out.println(Arrays.toString(arrays));
    }

    private static void reverse(int[] array) {
        int maxIndex = array.length - 1;
        int halfLength = array.length / 2;
        int temp;

        for (int  i = 0; i < halfLength; i++) {
            temp = array[i];
            array[i] = array[maxIndex - i];
            array[maxIndex - i] = temp;
        }
    }

    private static int[] reverseCopy(int[] array) {
        int[] reversed = new int[array.length];
        int maxIndex = array.length - 1;

        for (int number : array) {
            reversed[maxIndex--] = number;
        }

        return reversed;
    }

}
