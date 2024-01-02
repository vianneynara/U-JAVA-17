package challenge;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * This exercise uses nested class and anonymous class to sort a list of immutable record Employee.
 * */
public class Main {

	public static void main(String[] args) {
		List<Employee> list = new ArrayList<>(List.of(
			new Employee("John", "Doe", "2010-10-10"),
			new Employee("Peter", "Smith", "2011-10-10"),
			new Employee("Mary", "Jane", "2012-10-10"),
			new Employee("Paul", "Walker", "2013-10-10"),
			new Employee("Alice", "Cooper", "2014-10-10")
		));

		theMethod(list);
	}

	private static void theMethod(List<Employee> list) {
		class MutableEmployee {
			private String fullName;
			private int yearsWorked;

			public MutableEmployee(Employee employee) {
				this.fullName = employee.firstName() + " " + employee.lastName();
				this.yearsWorked = LocalDate.now().getYear() - Integer.parseInt(employee.hireDate().substring(0, 4));
			}
		}

		// Assign the list of Employee to a new list of Employee
		List<MutableEmployee> newList = new ArrayList<>();
		for (Employee employee : list) {
			newList.add(new MutableEmployee(employee));
		}

		// Using anonymous class to sort by yearsWorked / fullName
		newList.sort(new Comparator<MutableEmployee>() {
			@Override
			public int compare(MutableEmployee o1, MutableEmployee o2) {
				return o1.yearsWorked - o2.yearsWorked;
//				return o1.fullName.compareTo(o2.fullName);
			}
		});

		// Print the sorted list
		for (MutableEmployee employee : newList) {
			System.out.printf("%-20s %02d years worked%n", employee.fullName, employee.yearsWorked);
		}
	}
}
