import java.lang.reflect.Array;
import java.util.Arrays;

public class CountingSort {

	public static void main(String[] args) {
		int[] arr = {1, 0, 3, 1, 3, 1};
		System.out.println("unsorted: " + Arrays.toString(arr));
		int[] sortedArr = countingSort(arr);
		System.out.println("  sorted: " + Arrays.toString(sortedArr));
	}

	private static int[] countingSort(int[] arr) {
		int[] newArr = new int[arr.length];

		// Finding out the maximum value of the input array
		int max = 0;
		for (int j : arr) {
			if (j > max) max = j;
		}

		// Since the max amount does not include 0, we need to add a head by one space.
		int[] counterArray = new int[max + 1];
		System.out.println("counterArray: " + Arrays.toString(counterArray));

		// Increment the space when an element from the input matches
		for (int i = 0; i < arr.length; i++) {
			counterArray[arr[i]]++;
		}
		System.out.println("counterArray: " + Arrays.toString(counterArray));

		// Shifting the values of each `counterArray` to the right by summing
		for (int i = 1; i < counterArray.length; i++) {
			counterArray[i] += counterArray[i - 1];
		}
		System.out.println("counterArray: " + Arrays.toString(counterArray));

		// Generating the new array from the counter array
		for (int i = newArr.length - 1; i >= 0; i--) {
			newArr[counterArray[arr[i]] - 1] = arr[i];
			counterArray[arr[i]]--;
		}

		return newArr;
	}
}
