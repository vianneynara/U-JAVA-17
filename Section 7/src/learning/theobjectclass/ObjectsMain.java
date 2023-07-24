package learning.theobjectclass;

public class ObjectsMain extends Object {
    public static void main(String[] args) {
        learning.theobjectclass.Student max = new learning.theobjectclass.Student("Max", 21);
        System.out.println(max);

        PrimarySchoolStudent jimmy = new PrimarySchoolStudent(
                "Jimmy",
                8,
                "Carol"
        );
    }
}

class Student {
    private String name;
    private int age;

    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

//    @Override
//    public String toString() {
//        return super.toString();
//    }


    @Override
    public String toString() {
        return name + " is " + age;
//        return "learning.student.Student{" +
//                "name='" + name + '\'' +
//                ", age=" + age +
//                '}';
    }
}

class PrimarySchoolStudent extends learning.theobjectclass.Student {
    private String parentName;

    PrimarySchoolStudent(String name, int age, String parentName) {
        super(name, age);
        this.parentName = parentName;
    }

    @Override
    public String toString() {
        return parentName + "'s kid, " + super.toString();
    }
}