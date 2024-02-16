package tasks;

import java.util.*;

public class Main {

	private static void sortAndPrint(String header, Collection<Task> collection) {
		sortAndPrint(header, collection, null);
	}

	private static void sortAndPrint(String header, Collection<Task> collection, Comparator<Task> sorter) {
		System.out.println("_".repeat(100));
		System.out.println(header);

		List<Task> list = new ArrayList<>(collection);
		list.sort(sorter);
		list.forEach(System.out::println);
		System.out.println();
	}

	public static void main(String[] args) {

		Set<Task> tasks = TaskData.getTasks("all");
		sortAndPrint("All tasks", tasks);

		Comparator<Task> sortByPriority = Comparator.comparing(Task::getPriority);
		Set<Task> annTasks = TaskData.getTasks("Ann");
		sortAndPrint("Ann's tasks", annTasks, sortByPriority);

		// using the methods in `TaskApp`

		Set<Task> bobTasks = TaskData.getTasks("Bob");
		Set<Task> carolTasks = TaskData.getTasks("Carol");
		List<Set<Task>> mergedTasks = List.of(annTasks, bobTasks, carolTasks);

		Set<Task> assignedTasks = TaskApp.getUnion(mergedTasks);
		sortAndPrint("Assigned Tasks", assignedTasks);

		// printing every task

		Set<Task> everyTask = TaskApp.getUnion(List.of(tasks, assignedTasks));
		sortAndPrint("Every Task", everyTask);

		// missingTasks gets the difference between everyTask and tasks,
		// which are the tasks that are not assigned in `tasks` but is being
		// assigned.

		Set<Task> missingTasks = TaskApp.getDifference(everyTask, tasks);
		sortAndPrint("Missing Tasks", missingTasks);

		// Which tasks haven't been assigned?
		// To get this, we can find whether the tasks in `tasks` are
		// not in `assignedTasks`.

		Set<Task> unassignedTasks = TaskApp.getDifference(tasks, assignedTasks);
		sortAndPrint("Unassigned Tasks", unassignedTasks);


		// Which tasks are being worked on by more than one person?

		Set<Task> overlapped = TaskApp.getUnion(List.of(
			TaskApp.getIntersect(annTasks, bobTasks),
			TaskApp.getIntersect(annTasks, carolTasks),
			TaskApp.getIntersect(bobTasks, carolTasks)
		));
		sortAndPrint("Overlapped Tasks", overlapped, sortByPriority);

		// Getting the overlapping tasks from the merged tasks, merging tasks
		// that are being worked on by more than one person.

		List<Task> overlapping = new ArrayList<>();
		for (var set : mergedTasks) {
			Set<Task> dupes = TaskApp.getIntersect(set, overlapped);
			overlapping.addAll(dupes);
		}
		Comparator<Task> priorityNatural = sortByPriority.thenComparing(Comparator.naturalOrder());
		sortAndPrint("Overlapping Tasks", overlapping, priorityNatural);
	}
}
