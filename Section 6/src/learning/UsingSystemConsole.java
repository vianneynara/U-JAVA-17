package learning;

import java.util.Scanner;

public class UsingSystemConsole {
    public static String getInputFromConsole(int currentYear) {
        String name = System.console().readLine("Hi, what's your name? ");
        System.out.println("Hi " + name + ", thanks for taking the course!");

        String dateOfBirth = System.console().readLine("What year were you born? ");
        int age = currentYear - Integer.parseInt(dateOfBirth);

        return "So you are " + age + " years old";
    }

    public static int checkData(int currentYear, String yearOfBirth) {
        int yearInput = Integer.parseInt(yearOfBirth);
        return ((yearInput <= currentYear) && (yearInput >= (currentYear - 125))) ? (currentYear - yearInput) : -1;
    }

    public static String getInputFromScanner(int currentYear) {
        Scanner in = new Scanner(System.in);
        String name;
        int age;
        boolean validDateOfBirth;

        System.out.print("What is your name? "); name = in.nextLine();
        System.out.println("Hi " + name + "!");
        do {
            System.out.print("What year were you born? ");
            age = checkData(currentYear, in.nextLine());
            validDateOfBirth = age >= 0;
        } while (!validDateOfBirth);

        return "So you are " + age + " years old";
    }

    public static void main(String[] args) {
        int currentYear = 2022;

        try {
            System.out.println(getInputFromConsole(currentYear));
        } catch (NullPointerException e) {
            System.out.println(getInputFromScanner(currentYear));
        }
    }
}
