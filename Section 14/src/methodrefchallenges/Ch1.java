package methodrefchallenges;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.UnaryOperator;

public class Ch1 {

	private static Random random = new Random();

	private record Person(String firstName) {

		public String lastName(String s) {
			return firstName + " " + s.substring(0, s.indexOf(" "));
		}
	}

	public static void main(String[] args) {
		String[] names = {"Bob", "Alice", "Tim", "Tom", "Mike"};

		Person nara = new Person("Nara");
		List<UnaryOperator<String>> strFuncs = List.of(
			String::toUpperCase,
			(s) -> s + " " + (char)(random.nextInt(26) + 'A') + ". ",
			(s) -> s.substring(0, s.lastIndexOf(" ")) + " " + new StringBuilder(s.substring(0, s.indexOf(" "))).reverse(),
			Ch1::reverse,
			String::new,
//			(s) -> new String("Huzzah " + s),
			String::valueOf,
			nara::lastName,
			(new Person("Emilia 💜"))::lastName
		);

		System.out.println("Original array: " + Arrays.toString(names) + "\n");
		applyChanges(names, strFuncs);
		System.out.println("\nFinal array: " + Arrays.toString(names));
	}

	private static void applyChanges(String[] names, List<UnaryOperator<String>> strFuncs) {
		// masking the array with list methods
		List<String> mNames = Arrays.asList(names);
		for (var func : strFuncs) {
			mNames.replaceAll((s) -> s.transform(func));
			System.out.println(Arrays.toString(names));
		}
	}

	private static String reverse(String s) {
		return new StringBuilder(s).reverse().toString();
	}
}
