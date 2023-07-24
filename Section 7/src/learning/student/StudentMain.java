package learning.student;

public class StudentMain {
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            RDFStudent s = new RDFStudent(
                    "0000" + i,
                    switch (i) {
                        case 1 -> "Nara";
                        case 2 -> "Yoga";
                        case 3 -> "Bayu";
                        case 4 -> "Rio";
                        case 5 -> "Ferly";
                        default -> "anonymous";
                    },
                    "04/09/2001",
                    "Testing Class"
            );
            System.out.println(s);
        }
        System.out.println("\n");

        Student pojoStudent = new Student("00009", "Vito", "02/11/2001", "JavaScript Class");
        RDFStudent recordStudent = new RDFStudent("00008", "Reva", "21/04/2001", "Python Class");

        System.out.println(pojoStudent);
        System.out.println(recordStudent);

        System.out.println("\n");

        pojoStudent.setClassList(pojoStudent.getClassList() + ", Python Masterclass");
//        recordStudent.setClassList(recordStudent.getClassList() + ", Python Masterclass");

        System.out.println("\n");

        System.out.println(pojoStudent.getName() + " is taking " + pojoStudent.getClassList());
        System.out.println(recordStudent.name() + " is taking " + recordStudent.classList());
    }
}
