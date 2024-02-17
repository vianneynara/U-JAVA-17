package contact;

import java.util.*;

public class TreeSetMain {

	public static void main(String[] args) {

		List<Contact> phones = ContactData.getData("phone");
		List<Contact> emails = ContactData.getData("email");

		// Contact doesn't implement Comparable, thus we should create a comparator
		// to make the TreeSet work.
		Comparator<Contact> sorter = Comparator.comparing(Contact::getName);
		NavigableSet<Contact> sorted = new TreeSet<>(sorter);
		sorted.addAll(phones);
		sorted.forEach(System.out::println);

		NavigableSet<String> justNames = new TreeSet<>();
		phones.forEach(p -> justNames.add(p.getName()));
		System.out.println(justNames);

		NavigableSet<Contact> fullSet = new TreeSet<>(sorted);
		fullSet.addAll(emails);
		fullSet.forEach(System.out::println);

		List<Contact> fullList = new ArrayList<>(phones);
		fullList.addAll(emails);
		fullList.sort(sorted.comparator());
		System.out.println("--------------------------------");
		fullList.forEach(System.out::println);

		Contact min = Collections.min(fullList, fullSet.comparator());
		Contact max = Collections.max(fullList, fullSet.comparator());

		Contact first = fullSet.first();
		Contact last = fullSet.last();

		System.out.println("--------------------------------");
		System.out.printf("min = %s, first = %s%n", min.getName(), first.getName());
		System.out.printf("max = %s, last = %s%n", max.getName(), last.getName());
		System.out.println("--------------------------------");

		NavigableSet<Contact> copiiedSet = new TreeSet<>(fullSet);
		System.out.println("First el: " + copiiedSet.pollFirst());
		System.out.println("Last el: " + copiiedSet.pollLast());
		copiiedSet.forEach(System.out::println);
		System.out.println("--------------------------------");

		Contact daffy = new Contact("Daffy Duck");
		Contact daisy = new Contact("Daisy Duck");
		Contact snoopy = new Contact("Snoopy");
		Contact archie = new Contact("Archie");

		for (var c : List.of(daffy, daisy, last, snoopy)) {
			// ceiling is finding the least element greater than or equal to the given
			System.out.printf("ceiling(%s) = %s%n", c.getName(), fullSet.ceiling(c));
			// higher is finding the least but greater than the given element
			System.out.printf("higher(%s) = %s%n", c.getName(), fullSet.higher(c));
		}

		for (var c : List.of(daffy, daisy, first, archie)) {
			// floor is finding the greatest element less than or equal to the given
			System.out.printf("floor(%s) = %s%n", c.getName(), fullSet.floor(c));
			// lower is finding the greatest but less than the given element
			System.out.printf("lower(%s) = %s%n", c.getName(), fullSet.lower(c));
		}
		System.out.println("--------------------------------");

		NavigableSet<Contact> descendingSet = fullSet.descendingSet();
		descendingSet.forEach(System.out::println);
		System.out.println("--------------------------------");

		Contact lastContact = descendingSet.pollLast();
		System.out.println("Last contact: " + lastContact);
		descendingSet.forEach(System.out::println);
		System.out.println("--------------------------------");
		fullSet.forEach(System.out::println);
		System.out.println("--------------------------------");

		Contact marion = new Contact("Maid Marion");
		var headSet = fullSet.headSet(marion, true);
		headSet.forEach(System.out::println);
		System.out.println("--------------------------------");

		var tailSet = fullSet.tailSet(marion, false);
		tailSet.forEach(System.out::println);
		System.out.println("--------------------------------");

		Contact linus = new Contact("Linus Van Pelt");
		var subSet = fullSet.subSet(linus, false, marion, true);
		subSet.forEach(System.out::println);
	}
}
