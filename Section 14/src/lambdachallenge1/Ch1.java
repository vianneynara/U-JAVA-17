package lambdachallenge1;

import java.util.Arrays;
import java.util.function.Consumer;

public class Ch1 {

	public static void main(String[] args) {
		// Raw usage:
		Consumer<String> printTheParts = new Consumer<String>() {
			@Override
			public void accept(String sentence) {
				String[] parts = sentence.split(" ");
				for (String part : parts) {
					System.out.println(part);
				}
			}
		};

		String sentence = "I am so in love with Emilia!";
		// my attempt 1:
		Arrays.asList(sentence.split(" ")).forEach(part -> System.out.println(part));
		// my attempt 2 (the lambda):
		Consumer<String> printTheWords = (String words) -> {
			for (String word : words.split(" ")) {
				System.out.println(word);
			}
		};
		// my attempt 3 (twist of attempt 2):
		Consumer<String> printTheWerds = (String words) -> {
			String[] werds = words.split(" ");
			Arrays.asList(werds).forEach(werd -> System.out.println(werd));
		};

		System.out.println("-----");
		// testing `printTheWords` Consumer interface
		printTheWords.accept(sentence);

		System.out.println("-----");
		printTheWerds.accept(sentence);
	}
}
