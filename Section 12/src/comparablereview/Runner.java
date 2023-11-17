package comparablereview;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Runner {

	public static void main(String[] args) {

		Student nara = new Student("Nara", "Java");
		Student[] students = {nara, new Student("Yoga", "Java"), new Student("Rio", "C++"), new Student("Reva", "Python")};

		var queryList = new QueryList<>(List.of(students));
		var matches = queryList.getMatches("coursE", "c++");
		printStudentList(matches);

		System.out.println("unsorted: " + Arrays.toString(students));
		Arrays.sort(students);
		System.out.println("sorted	: " + Arrays.toString(students));

		Comparator<Student> gpaSorter = new StudentGPAComparator();
		Arrays.sort(students, gpaSorter);
		System.out.println("sorted	: " + Arrays.toString(students));
		Arrays.sort(students, gpaSorter.reversed());
		System.out.println("reverse	: " + Arrays.toString(students));

		var queryResult = QueryList.getMatches(List.of(students), "coURse", "java");
		printStudentList(queryResult);
	}

	public static void printStudentList(List<? extends Student> students) {
		System.out.println("List of students: ");
		for (var s : students) {
			System.out.println(" > " + s);
		}
	}
}