package staticnested;

import java.util.Comparator;

public class Employee {

	private int id;
	private String name;
	private String hireDate;

	public Employee() {
	}

	public Employee(int id, String name, String hireDate) {
		this.id = id;
		this.name = name;
		this.hireDate = hireDate;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getHireDate() {
		return hireDate;
	}

	@Override
	public String toString() {
		return "%2s %-10s %10s".formatted(id, name, hireDate);
	}

	/**
	 * EmployeeComparator is a static nested class used to sort employees based on their name, id, or hire date.
	 *
	 * @param <T> Employee or any subclass of Employee
	 */
	static class EmployeeComparator<T extends Employee> implements Comparator<Employee> {

		private final String type;

		public EmployeeComparator() {
			this.type = "name";
		}

		public EmployeeComparator(String type) {
			this.type = type;
		}

		@Override
		public int compare(Employee o1, Employee o2) {
			return switch (type) {
				case "name" -> o1.getName().compareTo(o2.getName());
				case "id" -> o1.getId() - o2.getId();
				case "hireDate" -> o1.getHireDate().compareTo(o2.getHireDate());
				default -> throw new IllegalArgumentException("Invalid type: " + type);
			};
		}
	}
}
