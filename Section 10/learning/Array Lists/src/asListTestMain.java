import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class asListTestMain {
    public static void main(String[] args) {
        String[] originalArray = new String[] {"First", "Third", "Second"};
        var originalList = Arrays.asList(originalArray);
        /*
        this makes a REFERENCE as List of Strings in a variable, immutable size too!
        you convert it to type List so that you can access the values inside the ARRAY
        using methods from List class.
         */

        originalList.set(0, "One");
        System.out.println("list:   " + originalList);
        System.out.println("array:  " + Arrays.toString(originalArray));

        originalList.set(0, "one");
        originalList.sort(Comparator.naturalOrder());
        System.out.println("list:   " + originalList);
        System.out.println("array:  " + Arrays.toString(originalArray));

//        originalList.remove("one"); // doesnt work
//        originalList.add("fourth"); // doesnt work

        List<String> newList = Arrays.asList("Sunday", "Monday", "Tuesday");
        System.out.println(newList);

        ArrayList<String> stringArrayList = new ArrayList<>(List.of("Jan", "Feb", "Mar"));
        ArrayList<ArrayList<String>> stringArrayList2 = new ArrayList<>(List.of(new ArrayList<>(List.of("Jan", "Feb", "Mar"))));

        String[] stringArray = stringArrayList.toArray(new String[0]);

        System.out.println(Arrays.toString(stringArray));

        // SUMMARY
        System.out.println(">>> SUMMARY SECTION <<<");
        List<Integer> list1 = Arrays.asList(1, 2, 3);   // MUTABLE, NON-RESIZEABLE
        List<Integer> list2 = List.of(1, 2, 3);         // IMMUTABLE

        // Modifying the first element of list1 also modifies the original array
        list1.set(0, 10);
        System.out.println(list1); // Output: [10, 2, 3]
        System.out.println(Arrays.toString(list1.toArray())); // Output: [10, 2, 3]

        // Attempting to modify the first element of list2 throws an exception
        try {
            list2.set(0, 10); // Throws UnsupportedOperationException
        } catch (UnsupportedOperationException e) {
            System.out.println("UnsupportedOperationException: " + e.getMessage());
        }

    }
}
