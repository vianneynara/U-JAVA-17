package challenges.person;

public class Person {
    private String firstName;
    private String lastName;
    private int age;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = (age >= 0 && age <= 100) ? (age) : 0;
    }

    public boolean isTeen() {
        return (this.age > 12 && this.age < 20);
    }

    public String getFullName() {
        return (this.firstName.isEmpty() && this.lastName.isEmpty()) ? "" : (this.firstName.isEmpty()) ? this.lastName : (this.lastName.isEmpty()) ? this.firstName : (this.firstName + " " + this.lastName);
    }
}
