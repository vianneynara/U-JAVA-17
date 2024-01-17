package lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;

public class Main {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>(List.of(
			"Alpha", "Bravo", "Charlie", "Delta"
		));

		list.forEach((var label) -> System.out.println(label));

		System.out.println("-----");
		list.forEach((String string) -> {
			char first = string.charAt(0);
			System.out.println(string + " means " + first);
		});

		String prefix = "Nato: ";
		list.forEach((String string) -> {
			char first = string.charAt(0);
			System.out.println(prefix + " " + string + " means " + first);
		});
		// can't do this:
//		prefix =

		int result = calculator((a, b) -> a + b, 1, 2);
		var result2 = calculator((a, b) -> a * b, 2.0, 3.0);
		var result3 = calculator(
			(a, b) -> a.toUpperCase() + " " + b.toUpperCase(),
			"Ralph", "Kramden");

		var coords = Arrays.asList(
			new double[]{49.0, -95.3},
			new double[]{24.1, -82.1},
			new double[]{31.0, -72.2}
		);

		coords.forEach(
			(double[] pair) -> System.out.println(pair[0] + ", " + pair[1])
		);

		BiConsumer<Double, Double> p = (latitude, longitude) -> {
			System.out.println("lat: " + latitude + ", lon:" + longitude);
		};

		var firstPoint = coords.get(0);
		processPoint(firstPoint[0], firstPoint[1], p);

		System.out.println("-----");
		coords.forEach(pair -> processPoint(pair[0], pair[1], p));

		System.out.println("-----");
		coords.forEach(pair -> processPoint(pair[0], pair[1],
			(latitude, longitude) -> {
				System.out.println("lat: " + latitude + ", lon:" + longitude);
			}));

		list.removeIf(s -> s.equalsIgnoreCase("bravo"));
		list.forEach(s -> System.out.println(s));
		list.replaceAll(s -> s.charAt(0) + " - " + s.toUpperCase());

		System.out.println("-----");
		list.forEach(s -> System.out.println(s));

		String[] emptyStrings = new String[10];
		System.out.println(Arrays.toString(emptyStrings));

		Arrays.fill(emptyStrings, "");
		System.out.println(Arrays.toString(emptyStrings));

		Arrays.setAll(emptyStrings, i -> "%02d".formatted((i + 1)) + ". ");
		System.out.println(Arrays.toString(emptyStrings));

		Arrays.setAll(emptyStrings, i -> (i + 1) + ". "
			+ switch (i) {
				case 0 -> "one";
				case 1 -> "two";
				case 2 -> "three";
				default -> "...";
			}
		);
		System.out.println(Arrays.toString(emptyStrings));

		String[] names = {"Ann", "Bob", "Cathy", "Dan", "Eve"};
		String[] randomList = randomSelectedValues(10, names,
			() -> new Random().nextInt(0, names.length));
		System.out.println(Arrays.toString(randomList));
	}

	public static <T> T calculator(BinaryOperator<T> function, T value1, T value2) {
		T result = function.apply(value1, value2);
		System.out.println("Result: " + result);
		return result;
	}

	public static <T> void processPoint(T t1, T t2, BiConsumer<T, T> consumer) {
		consumer.accept(t1, t2);
	}

	public static String[] randomSelectedValues(int count,
												String[] values,
												Supplier<Integer> s) {
		String[] selectedValues = new String[count];
		for (int i = 0; i < count; i++) {
			selectedValues[i] = values[s.get()];
		}
		return selectedValues;
	}
}
