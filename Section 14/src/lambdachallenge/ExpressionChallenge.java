package lambdachallenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.UnaryOperator;

public class ExpressionChallenge {

	public static void main(String[] args) {

		// Array of string which is populated with first names with mixed case, include at least
		// one name which is spelled the same, backwards and forwards like 'bob'
		String[] names = {"Bob", "Alice", "Tim", "Tom", "Mike"};

		// maybe use `Arrays.setAll` or `List.replaceAll` to change values

		// Transforming names to uppercase:
		UnaryOperator<String> toUpperCase = source -> source.toUpperCase();
		Arrays.asList(names).replaceAll(toUpperCase);
		System.out.println(Arrays.toString(names));
		System.out.println("-----");

		// Add randomly generated middle initial with period, then use Arrays.setAll to add middle names to names with lambda
		// using set all, which means we'll need to use an index int generator
		Arrays.setAll(
			names, (i) -> names[i] + " " + (char)(new Random().nextInt(26) + 'A') + "."
		);
		System.out.println(Arrays.toString(names));
		System.out.println("-----");

		// Add a last name that is the reverse of the first name
		UnaryOperator<String> addLastName = s -> {
			String[] parts = s.split(" ");
			// ensure that middle name isn't reversed
			return parts[0] + " " + parts[1] + " " + new StringBuilder(parts[0]).reverse();
		};
		// masking the array with list methods
		Arrays.asList(names).replaceAll(addLastName);
		System.out.println(Arrays.toString(names));
		System.out.println("-----");

		// Remove if last name equals the first name
		List<String> mNames = new ArrayList<>(List.of(names));
		mNames.removeIf((String s) -> {
			String[] parts = s.split(" ");
			if (parts.length < 2)
				return false;
			return parts[0].equalsIgnoreCase(parts[parts.length - 1]);

			// OR
//			s.substring(0, s.indexOf(" ")).equals(s.substring(s.lastIndexOf(" ")+1));
		});
		mNames.forEach(s -> System.out.println(s));
	}
}
