package challenges;

public class DayOfWeek {
    public static void printDayOfWeek(int day) {
        String dayOfWeek = switch (day) {
            case 0 -> day + " stands for Sunday";
            case 1 -> day + " stands for Monday";
            case 2 -> day + " stands for Tuesday";
            case 3 -> day + " stands for Wednesday";
            case 4 -> day + " stands for Thursday";
            case 5 -> day + " stands for Friday";
            case 6 -> day + " stands for Saturday";
            default -> day + "stands for Invalid Day";
        };
        System.out.println(dayOfWeek);
    }

    public static void printWeekDay(int day) {
        String dayOfWeek = "Invalid Day";

        if (day == 0) dayOfWeek = "Sunday";
        else if (day == 1) dayOfWeek = "Monday";
        else if (day == 2) dayOfWeek = "Tuesday";
        else if (day == 3) dayOfWeek = "Wednesday";
        else if (day == 4) dayOfWeek = "Thursday";
        else if (day == 5) dayOfWeek = "Friday";
        else if (day == 6) dayOfWeek = "Saturday";

        System.out.println(day + " is " + dayOfWeek);
    }
    public static void main(String[] args) {
        printDayOfWeek(5);
        printWeekDay(5);
    }
}
