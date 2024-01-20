package methodreferences;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;

class PlainOld {

	private static int last_id = 1;
	private int id;

	public PlainOld() {
		this.id = PlainOld.last_id++;
		System.out.println("PlainOld created: " + id);
	}

	public PlainOld(int newLastId) {
		this.id = last_id = newLastId;
		System.out.println("PlainOld created: " + id);
	}
}

public class Main {

	public static void main(String[] args) {
		List<String> names = new ArrayList<>(List.of(
			"Bob", "Alice", "Tim", "Tom", "Mike"
		));
		// directly use the method reference
		names.forEach(System.out::println);

		calculator(Integer::max, 10, 25);

		calculator(Double::sum, 2.5, 7.1);

//		Supplier<PlainOld> reference1 = () -> new PlainOld();
		// to: (deferred, not invoked instantly)
		Supplier<PlainOld> reference1 = () -> new PlainOld(10);

		PlainOld newPojo = reference1.get();

		System.out.println("Generating array of PlainOld");
		PlainOld[] arr = seedArray(PlainOld::new, 10);

		// Difference between Bounded and Unbounded method references
		// String::concat sets the first parameter as the instance, then
		// the second parameter is passed as the argument to the method
		calculator((s1, s2) -> s1.concat(s2), "Hello", " World");
		calculator(String::concat, "Hello", " World");

		// Unlike System.out.println, which is a static method, so the
		// first parameter is the class, and the second parameter is the
		// argument to the method

		BinaryOperator<String> b1 = String::concat;
		BiFunction<String, String, String> b2 = String::concat;

		// Non static method called on a non static context
//		UnaryOperator<String> u1 = String::concat;

//		UnaryOperator<String> u1 = (s1) -> s1.toUpperCase(); // TO:
		UnaryOperator<String> u1 = String::toUpperCase;

		System.out.println(b1.apply("Hello ", "World"));
		System.out.println(b2.apply("Hello ", "World"));
		System.out.println(u1.apply("Hello"));

		String result = "Hello".transform(u1);
		System.out.println("Result of transform: " + result);
		result = result.transform(String::toLowerCase);
		System.out.println("Result of transform: " + result);

		Function<String, Boolean> f0 = String::isEmpty;
		boolean resultBoolean = result.transform(f0);
		System.out.println("Result of transform: " + resultBoolean);
	}

	private static <T> void calculator(BinaryOperator<T> function, T value1, T value2) {
		T result = function.apply(value1, value2);
		System.out.println("Result: " + result);
	}

	private static PlainOld[] seedArray(Supplier<PlainOld> reference, int count) {
		PlainOld[] arr = new PlainOld[count];
		Arrays.setAll(arr, (i) -> reference.get());
		return arr;
	}
}
