package comparablereview;

import java.util.*;

interface Queryable {

	boolean matchFieldValue(String field, String value);
}

class QueryList <T extends Queryable> {

	private List<T> items;

	public QueryList(List<T> items) {
		this.items = items;
	}

	public static <T extends Student & Queryable> List<T> getMatches(List<T> list, String fieldName, String value) {
		List<T> query = new ArrayList<>();
		for (var s : list) {
			if (s.matchFieldValue(fieldName, value)) {
				query.add(s);
			}
		}
		return query;
	}

	public List<T> getMatches(String field, String value) {
		List<T> query = new ArrayList<>();
		for (var s : items) {
			if (s.matchFieldValue(field, value)) {
				query.add(s);
			}
		}
		return query;
	}
}

class StudentGPAComparator implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {
		return (o1.gpa + o1.name).compareTo(o2.gpa + o2.name);
	}
}

public class Student implements Comparable<Student>, Queryable {

	private static int LAST_ID = 1000;
	private static Random random = new Random();
	private int id;
	String name;
	String course;
	protected double gpa;

	public Student(String name, String course) {
		this.name = name;
		this.course = course.toLowerCase();
		id = LAST_ID++;
		gpa = random.nextDouble(1.0, 4.0);
	}

	@Override
	public String toString() {
		return "%d - %s (%.2f)".formatted(id, name, gpa);
	}

	public int compareTo(Student o) {
		return Integer.compare(this.id, o.id);
	}

	public int compareTo(int id) {
		return Integer.compare(this.id, id);
	}

	@Override
	public boolean matchFieldValue(String fieldName, String value) {
		final String field = fieldName.toUpperCase();
		return switch (field) {
			case "ID" -> id == Integer.parseInt(value);
			case "NAME" -> name.equalsIgnoreCase(value.toLowerCase());
			case "COURSE" -> course.equalsIgnoreCase(value.toLowerCase());
			case "GPA" -> gpa == Double.parseDouble(value);
			default -> false;
		};
	}
}