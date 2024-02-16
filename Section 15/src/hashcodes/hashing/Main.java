package hashcodes.hashing;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

	public static void main(String[] args) {

		String aText = "Hello";
		String bText = "Hello";
		String cText = String.join("l", "He", "lo");
		String dText = "He".concat("llo");
		String eText = "hello";

		List<String> hellos =
			Arrays.asList(aText, bText, cText, dText, eText);

		hellos.forEach(s -> System.out.println(s + ": " + s.hashCode()));

		Set<String> mySet = new HashSet<>(hellos);
		System.out.println("mySet = " + mySet);
		System.out.println("size = " + mySet.size());

		for (String s : mySet) {
			System.out.print(s + ": ");
			for (int i = 0; i < hellos.size(); i++) {
				if (s == hellos.get(i)) {
					System.out.print(i + ", ");
				}
			}
			System.out.println();
		}
	}
}
