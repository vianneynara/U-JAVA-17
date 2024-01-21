package chaininglambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {

	public static void main(String[] args) {
		// using either `andThen` and `compose`

		String name = "Nara";
		Function<String, String> uCase = String::toUpperCase;;
		System.out.println(uCase.apply(name));

		Function<String, String> lastName = s -> s.concat(" Emilia");
		Function<String, String> uCaseLastName = uCase.andThen(lastName);

		System.out.println(uCaseLastName.apply(name));

		// compose is the opposite of andThen, which executes the passed first, then the called lambda
		// andThen executes the called lambda first, then the passed lambda
		uCaseLastName = uCase.compose(s -> s.concat(" Emilia"));
		System.out.println(uCaseLastName.apply(name));

		// T: type input, R: type result

		Function<String, String[]> f0 = uCase
			.andThen(s -> s.concat(" Emilia"))
			.andThen(s -> s.split(" "));
		System.out.println(Arrays.toString(f0.apply(name)));

		Function<String, String> f1 = uCase
			.andThen(s -> s.concat(" Emilia"))
			.andThen(s -> s.split(" "))
			.andThen(s -> s[1].toUpperCase() + ", " + s[0]);
		System.out.println(f1.apply(name));

		Function<String, Integer> f2 = uCase
			.andThen(s -> s.concat(" Emilia"))
			.andThen(s -> s.split(" "))
			.andThen(s -> String.join(", ", s))
			.andThen(String::length);
		System.out.println(f2.apply(name));

		// ON CONSUMER
		String[] names = {"Bob", "Alice", "Tim", "Tom", "Mike"};
		Consumer<String> s0 = s -> System.out.print(s.charAt(0));
		Consumer<String> s1 = System.out::println;
		Arrays.asList(names).forEach(s0
			.andThen(s -> System.out.print(" - "))
			.andThen(s1));

		// ON PREDICATE
		Predicate<String> p1 = s -> s.equals("NARA");
		Predicate<String> p2 = s -> s.equalsIgnoreCase("Nara");
		Predicate<String> p3 = s -> s.startsWith("N");
		Predicate<String> p4 = s -> s.endsWith("e");

		// example boolean usage
		Predicate<String> isChar_5 = s -> (int) s.charAt(0) == 5;

		Predicate<String> combined1 = p1.or(p2);
		System.out.println("combined1 -> " + combined1.test(name));

		Predicate<String> combined2 = p3.and(p4);
		System.out.println("combined2 -> " + combined2.test(name));

		Predicate<String> combined3 = p3.and(p4).negate();
		System.out.println("combined3 -> " + combined3.test(name));

		record Person(String firstName, String lastName) { }

		List<Person> people = new ArrayList<>(List.of(
			new Person("Peter", "Pan"),
			new Person("Peter", "PumpkinEater"),
			new Person("Minnie", "Mouse"),
			new Person("Mickey", "Mouse")
		));

		people.sort((o1, o2) -> o1.lastName.compareTo(o2.lastName));
		people.forEach(System.out::println);

		System.out.println("--------------------------------------");
		people.sort(Comparator.comparing(Person::lastName) 	// sort by last name
			.thenComparing(Person::firstName));				// then by first name
		people.forEach(System.out::println);

		System.out.println("--------------------------------------");
		people.sort(Comparator.comparing(Person::lastName) 	// sort by last name
			.thenComparing(Person::firstName)				// then by first name
			.reversed());									// reverse it
		people.forEach(System.out::println);
	}
}
