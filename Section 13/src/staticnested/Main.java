package staticnested;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<Employee> employees = new java.util.ArrayList<>(List.of(
			new Employee(1, "John", "2010-10-10"),
			new Employee(2, "Peter", "2011-10-10"),
			new Employee(3, "Mary", "2012-10-10"),
			new Employee(8, "Paul", "2013-10-10"),
			new Employee(5, "Alice", "2014-10-10"),
			new Employee(6, "Bob", "2015-10-10"),
			new Employee(4, "Jack", "2016-10-10"),
			new Employee(7, "Jill", "2017-10-10"),
			new Employee(9, "Mike", "2018-10-10"),
			new Employee(10, "Susan", "2019-10-10")
		));

		// sort employees
		employees.sort(new Employee.EmployeeComparator<>("id"));

		// print employees
		for (Employee employee : employees) {
			System.out.println(employee);
		}

		System.out.println("Store Members");
		
		List<StoreEmployee> storeEmployees = new ArrayList<>(List.of(
			new StoreEmployee(1, "John", "2010-10-10", "Target"),
			new StoreEmployee(2, "Peter", "2011-10-10", "Walmart"),
			new StoreEmployee(3, "Mary", "2012-10-10", "Alfamart"),
			new StoreEmployee(8, "Paul", "2013-10-10", "Walmart"),
			new StoreEmployee(5, "Alice", "2014-10-10", "Target"),
			new StoreEmployee(6, "Bob", "2015-10-10", "Walmart"),
			new StoreEmployee(4, "Jack", "2016-10-10", "Alfamart"),
			new StoreEmployee(7, "Jill", "2017-10-10", "Alfamart"),
			new StoreEmployee(9, "Mike", "2018-10-10", "Target"),
			new StoreEmployee(10, "Susan", "2019-10-10", "Walmart")
		));

		// sort store employees using static EmployeeComparator
//		var comparator = new Employee.EmployeeComparator<>();
//		storeEmployees.sort(comparator);

		// sort store employees using non-static StoreComparator, it has to be instantiated using `new` keyword
//		var genericEmployee = new StoreEmployee();
//		var comparator = genericEmployee.new StoreComparator<>();
//		storeEmployees.sort(comparator);

		// inlining the above code
		storeEmployees.sort(new StoreEmployee().new StoreComparator<>());

		for (StoreEmployee storeEmployee : storeEmployees) {
			System.out.println(storeEmployee);
		}

		System.out.println("Pig Latin Names");
		addPigLatinName(storeEmployees);
	}

	public static void addPigLatinName(List<? extends StoreEmployee> list) {
		String lastName = "Piggy";
		class DecoratedEmployee extends StoreEmployee implements Comparable<DecoratedEmployee> {

			private String pigLatinName;
			private Employee originalInstance;

			public DecoratedEmployee(String pigLatinName, Employee originalInstance) {
				///////////////////////////////////////////////////////////////////////////////////////////////
				//	 EVERY VARIABLE THAT ARE ACCESSED BY LOCAL CLASSES MUST BE FINAL OR EFFECTIVELY FINAL.	 //
				//	 EFFECTIVELY FINAL MEANS THAT THE VARIABLE IS NOT DECLARED FINAL BUT IT IS NOT MODIFIED	 //
				//	 AFTER IT IS DECLARED.																	 //
				///////////////////////////////////////////////////////////////////////////////////////////////
				this.pigLatinName = pigLatinName + " " + lastName;
				this.originalInstance = originalInstance;
			}

			@Override
			public String toString() {
				return originalInstance.toString() + " " + pigLatinName;
			}

			@Override
			public int compareTo(DecoratedEmployee o) {
				return pigLatinName.compareTo(o.pigLatinName);
			}
		}

		List<DecoratedEmployee> newList = new ArrayList<>();

		for (var employee : list) {
			String name = employee.getName();
			String pigLatin = name.substring(1) + name.charAt(0) + "ay";
			newList.add(new DecoratedEmployee(pigLatin, employee));
		}

		// Illegal because lastName is not final or effectively final.
//		lastName = "Piggoy";

		// passing null in sort means it will use compareTo method of the object
		newList.sort(null);
		for (var dEmployee : newList) {
			System.out.println(dEmployee.originalInstance.getName() + " " + dEmployee.pigLatinName);
		}
	}
}
