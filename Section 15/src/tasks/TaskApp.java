package tasks;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TaskApp {

	public static Set<Task> getUnion(List<Set<Task>> taskSets) {
		Set<Task> union = new HashSet<>();

		for (var taskSet : taskSets) {
			union.addAll(taskSet);
		}
		return union;
	}

	public static Set<Task> getIntersect(Set<Task> a, Set<Task> b) {
		Set<Task> intersect = new HashSet<>(a);

		// retains the elements on b that are intersects `intersect`
		intersect.retainAll(b);
		return intersect;
	}

	public static Set<Task> getDifference(Set<Task> a, Set<Task> b) {
		Set<Task> difference = new HashSet<>(a);

		// removes the elements on b that intersects `difference`
		difference.removeAll(b);
		return difference;
	}


}
