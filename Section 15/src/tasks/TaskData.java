package tasks;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TaskData {

	private final static String allTasks = """
		Infrastructure, Logging, High
		Infrastructure, DB Access, Medium
		Infrastructure, Security, High
		Infrastructure, Password Policy, Medium
		Data Design, Task Table, Medium
		Data Design, Employee Table, Medium
		Data Design, Cross Reference Tables, High
		Data Design, Encryption Policy, High
		Data Access, Write Views, Low
		Data Access, Set Up Users, Low
		Data Access, Set Up Access Policy, Low""";

	private final static String annTasks = """
		Infrastructure, Security, High, In Progress
		Infrastructure, Password Policy,Medium, In Progress
		Research, Cloud solutions, Medium, In Progress
		Data Design, Encryption Policy, High
		Data Design, Project Table, Medium
		Data Access, Write Views,Low, In Progress""";

	private final static String bobTasks = """
		Infrastructure, Security, High, In Progress
		Infrastructure, Password Policy, Medium
		Data Design,Encryption Policy,High
		Data Access,Write Views, Low, In Progress""";

	private final static String carolTasks = """
		Infrastructure, Logging, High, In Progress
		Infrastructure, DB Access, Medium
		Infrastructure, Password Policy, Medium
		Data Design, Task Table, High
		Data Access, Write Views, Low""";

	private Set<Task> getAnnTasks() {
		Set<Task> taskSet = new HashSet<>();

		taskSet.add(new Task("Infrastructure", "Security", "Ann", TaskPriority.HIGH, TaskStatus.IN_PROGRESS));
		taskSet.add(new Task("Infrastructure", "Password Policy", "Ann", TaskPriority.MEDIUM, TaskStatus.IN_PROGRESS));
		taskSet.add(new Task("Research", "Cloud solutions", "Ann", TaskPriority.MEDIUM, TaskStatus.IN_PROGRESS));
		taskSet.add(new Task("Data Design", "Encryption Policy", "Ann", TaskPriority.HIGH));
		taskSet.add(new Task("Data Design", "Project Table", "Ann", TaskPriority.MEDIUM));
		taskSet.add(new Task("Data Access", "Write Views", "Ann", TaskPriority.LOW, TaskStatus.IN_PROGRESS));

		return taskSet;
	}

	private Set<Task> getBobTasks() {
		Set<Task> taskSet = new HashSet<>();
		taskSet.add(new Task("Infrastructure", "Security", "Bob", TaskPriority.HIGH, TaskStatus.IN_PROGRESS));
		taskSet.add(new Task("Infrastructure", "Password Policy", "Bob", TaskPriority.MEDIUM));
		taskSet.add(new Task("Data Design", "Encryption Policy", "Bob", TaskPriority.HIGH));
		taskSet.add(new Task("Data Access", "Write Views", "Bob", TaskPriority.LOW, TaskStatus.IN_PROGRESS));

		return taskSet;
	}

	private Set<Task> getCarolTasks() {
		Set<Task> taskSet = new HashSet<>();

		taskSet.add(new Task("Infrastructure", "Logging", "Carol", TaskPriority.HIGH, TaskStatus.IN_PROGRESS));
		taskSet.add(new Task("Infrastructure", "DB Access", "Carol", TaskPriority.MEDIUM));
		taskSet.add(new Task("Infrastructure", "Password Policy", "Carol", TaskPriority.MEDIUM));
		taskSet.add(new Task("Data Design", "Task Table", "Carol", TaskPriority.HIGH));
		taskSet.add(new Task("Data Access", "Write Views", "Carol", TaskPriority.LOW));

		return taskSet;
	}

	private Set<Task> getAllTasks() {
		Set<Task> taskSet = new HashSet<>();

		taskSet.add(new Task("Infrastructure", "Logging", TaskPriority.HIGH));
		taskSet.add(new Task("Infrastructure", "DB Access", TaskPriority.MEDIUM));
		taskSet.add(new Task("Infrastructure", "Security", TaskPriority.HIGH));
		taskSet.add(new Task("Infrastructure", "Password Policy", TaskPriority.MEDIUM));
		taskSet.add(new Task("Data Design", "Task Table", TaskPriority.MEDIUM));
		taskSet.add(new Task("Data Design", "Employee Table", TaskPriority.MEDIUM));
		taskSet.add(new Task("Data Design", "Cross Reference Tables", TaskPriority.HIGH));
		taskSet.add(new Task("Data Design", "Encryption Policy", TaskPriority.HIGH));
		taskSet.add(new Task("Data Access", "Write Views", TaskPriority.LOW));
		taskSet.add(new Task("Data Access", "Set Up Users", TaskPriority.LOW));
		taskSet.add(new Task("Data Access", "Set Up Access Policy", TaskPriority.LOW));

		return taskSet;

	}

	public static Set<Task> getTasks(String owner) {

		Set<Task> taskList = new HashSet<>();
		String user = ("ann,bob,carol".contains(owner.toLowerCase())) ? owner : null;

		String tasksData = switch (owner.toLowerCase()) {
			case "ann" -> annTasks;
			case "bob" -> bobTasks;
			case "carol" -> carolTasks;
			default -> allTasks;
		};

		for (String taskData : tasksData.split("\n")) {
			String[] data = taskData.split(",");
			Arrays.asList(data).replaceAll(String::trim);

			TaskStatus status = data.length <= 3 ? TaskStatus.IN_QUEUE : TaskStatus.valueOf(data[3].toUpperCase().replace(" ", "_"));

			TaskPriority priority = TaskPriority.valueOf(data[2].toUpperCase());

			taskList.add(new Task(data[0], data[1], user, priority, status));
		}

		return taskList;
	}

	public Set<Task> getData(String name) {
		Set<Task> taskSet = new HashSet<>();

		if (name.equals("Ann")) {
			taskSet = getAnnTasks();
		} else if (name.equals("Bob")) {
			taskSet = getBobTasks();
		} else if (name.equals("Carol")) {
			taskSet = getCarolTasks();
		} else if (name.equals("All")) {
			taskSet = getAllTasks();
		} else {
			throw new IllegalArgumentException("Invalid name!");
		}

		return taskSet;
	}

	public static void main(String[] args) {

	}
}
