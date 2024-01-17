package introlambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {

	private String test;

	record Person(String firstName, String lastName) {

		@Override
		public String toString() {
			return firstName + " "  + lastName;
		}
	}

	public static void main(String[] args) {

		List<Person> people = new ArrayList<>(Arrays.asList(
			new Person("Liam", "Smith"),
			new Person("Olivia", "Johnson"),
			new Person("Noah", "Williams"),
			new Person("Emma", "Brown"),
			new Person("Ava", "Jones"),
			new Person("Sophia", "Miller"),
			new Person("Jackson", "Davis"),
			new Person("Aiden", "Brown"),
			new Person("Lucas", "Rodriguez"),
			new Person("Mia", "Smith")
		));

		var comparatorLastName = new Comparator<Person>() {

			@Override
			public int compare(Person o1, Person o2) {
				return o1.lastName().compareTo(o2.lastName());
			}
		};

		people.sort((o1, o2) -> o1.lastName().compareTo(o2.lastName()));

		System.out.println(people);

		interface EnhancedComparator<T> extends Comparator<T> {

			int secondaryCompare(T o1, T o2);
		}

		// comparator that also implements Comparator's abstract methods.
		var mixedComparartor = new EnhancedComparator<Person>() {

			// Method to compare Person's first names
			@Override
			public int compare(Person o1, Person o2) {
				int result = o1.lastName().compareTo(o2.lastName());
				return result == 0 ? secondaryCompare(o1, o2) : result;
			}

			// Method to compare Person's last names
			@Override
			public int secondaryCompare(Person o1, Person o2) {
				return o1.firstName().compareTo(o2.firstName());
			}
		};

		people.sort(mixedComparartor);
		System.out.println(people);
	}
}
