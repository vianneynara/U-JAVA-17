package lambdachallenge;

import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class Ch2 {

	public static void main(String[] args) {

		UnaryOperator<String> everySecondChar = source -> {
			StringBuilder returnVal = new StringBuilder();
			for (int i = 0; i < source.length(); i++) {
				if (i % 2 == 1) {
					returnVal.append(source.charAt(i));
				}
			}
			return returnVal.toString();
		};

		// Challenge 3: apply it
		System.out.println(everySecondChar.apply("1234567890"));

		// Challenge 4: make `everySecondCharater` method

		// Challenge 5: pass "1234567890" to the method
		System.out.println(everySecondCharater(everySecondChar, "1234567890"));

		// Challenge 6: Supplier lambda interface
		Supplier<String> source = () -> "I love Java!";

		// Challenge 7: Use the supplier
		String iLoveJava = source.get();
		System.out.println(iLoveJava);
	}

	public static String everySecondCharater(UnaryOperator<String> function, String source) {
		return function.apply(source);
	}
}
