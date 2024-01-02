package staticnested;

import java.util.Comparator;

/**
	 * EmployeeComparator is a static nested class used to sort employees based on their name, id, or hire date.
	 *
	 * @param <T> Employee or any subclass of Employee
	 */
	public class EmployeeComparator<T extends Employee> implements Comparator<Employee> {

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