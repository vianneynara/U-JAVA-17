import staticnested.Employee;
import staticnested.EmployeeComparator;
import staticnested.StoreEmployee;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// Anonymous class example
public class RunMethods {

	public static void main(String[] args) {
		System.out.println("Store Members");

		List<StoreEmployee> storeEmployees = new ArrayList<>(List.of(
			new StoreEmployee(1, "John", "2010-10-10", "Target"),
			new StoreEmployee(2, "Peter", "2011-10-10", "Walmart"),
			new StoreEmployee(3, "Mary", "2012-10-10", "Alfamart"),
			new StoreEmployee(8, "Paul", "2013-10-10", "Walmart"),
			new StoreEmployee(5, "Alice", "2014-10-10", "Target")
		));

		var c0 = new EmployeeComparator<>();
		var c1 = new Employee.EmployeeComparator<StoreEmployee>();
		var c2 = new StoreEmployee().new StoreComparator<>();

		// Using local class to sort
		class NameSort<T> implements Comparator<StoreEmployee> {
			@Override
			public int compare(StoreEmployee o1, StoreEmployee o2) {
				return o1.getName().compareTo(o2.getName());
			}
		}
		var c3 = new NameSort<StoreEmployee>();

		// Using anonymous class
		var c4 = new Comparator<StoreEmployee>() {
			@Override
			public int compare(StoreEmployee o1, StoreEmployee o2) {
				return o1.getName().compareTo(o2.getName());
			}
		};

		sortIt(storeEmployees, c0);
		sortIt(storeEmployees, c1);
		sortIt(storeEmployees, c2);
		sortIt(storeEmployees, c3);
		sortIt(storeEmployees, c4);
		sortIt(storeEmployees, (o1, o2) -> o1.getName().compareTo(o2.getName()));
	}

	public static <T> void sortIt(List<T> list, Comparator<? super T> comparator) {
		list.sort(comparator);
		System.out.println("Sorting with: " + comparator);
		for (T t : list) {
			System.out.println(t);
		}
	}
}
