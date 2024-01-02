package staticnested;

import java.util.Comparator;

public class StoreEmployee extends Employee {

	private String store;

	public StoreEmployee() {
	}

	public StoreEmployee(int id, String name, String hireDate, String store) {
		super(id, name, hireDate);
		this.store = store;
	}

	@Override
	public String toString() {
		return "%-8s %s".formatted(store, super.toString());
	}

	/**
	 * To sort store employees based on their store name, then by their hire date if the store matches.
	 * */
	public class StoreComparator<T extends StoreEmployee> implements Comparator<StoreEmployee> {

		@Override
		public int compare(StoreEmployee o1, StoreEmployee o2) {
			int result = o1.store.compareTo(o2.store);

			// if store is the same, sort by the employee's hire date
			if (result == 0) {
				return new Employee.EmployeeComparator<>("hireDate").compare(o1, o2);
			}
			return result;
		}
	}
}
