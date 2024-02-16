package tasks;

import java.util.Objects;

enum TaskStatus {
	ASSIGNED, IN_PROGRESS, IN_QUEUE
}

enum TaskPriority {
	HIGH(3), MEDIUM(2), LOW(1);

	final int VALUE;

	TaskPriority(int value) {
		this.VALUE = value;
	}
	public int getValue() {
		return VALUE;
	}
}

public class Task implements Comparable<Task> {
	private String projectName;
	private String description;

	private String assignee;
	private TaskStatus status;
	private TaskPriority priority;

	/* Project only constructor */
	public Task(String projectName, String description, TaskPriority priority) {
		this(projectName, description, null, priority);
	}

	/* Project with assigned person */
	public Task(String projectName, String description, String assignee, TaskPriority priority) {
		this(projectName, description, assignee, priority, assignee == null ? TaskStatus.IN_QUEUE : TaskStatus.ASSIGNED);
	}

	/* Full constructor */
	public Task(String projectName, String description, String assignee, TaskPriority priority, TaskStatus status) {
		this.projectName = projectName;
		this.description = description;
		this.assignee = assignee;
		this.priority = priority;
		this.status = status;
	}

	// getters and setters

	public String getAssignee() {
		return assignee;
	}

	public void setAssignee(String assignee) {
		this.assignee = assignee;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public TaskStatus getStatus() {
		return status;
	}

	public void setStatus(TaskStatus status) {
		this.status = status;
	}

	public TaskPriority getPriority() {
		return priority;
	}

	public void setPriority(TaskPriority priority) {
		this.priority = priority;
	}

	@Override
	public String toString() {
		return "%-20s %-25s %-10s %-10s %s".formatted(projectName, description, assignee, priority, status);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Task task = (Task) o;

		if (!getProjectName().equals(task.getProjectName())) return false;
		return getDescription().equals(task.getDescription());
	}

	@Override
	public int hashCode() {
		int result = getProjectName().hashCode();
		result = 31 * result + getDescription().hashCode();
		return result;
	}

	/** Compares the task by the names and descriptions */
	@Override
	public int compareTo(Task o) {
		// sort by project name
		int result = this.projectName.compareTo(o.projectName);
		if (result == 0) {
			// then sort by project description
			result = this.description.compareTo(o.description);
		}
		return result;
	}
}
