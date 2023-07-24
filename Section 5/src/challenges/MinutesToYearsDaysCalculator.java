package challenges;

public class MinutesToYearsDaysCalculator {
    public static void printYearsAndDays(long minutes) {
        if (minutes < 0) System.out.println("Invalid Value");
        else {
            long days, years;

//            days = (minutes % 525600) / 1440;
//            years = minutes / 525600;

            long hours = minutes / 60;
            days = hours / 24;
            years = days / 365;

            days %= 365;

            System.out.println(minutes + " min = " + years + " y and " + days + " d");
        }
    }

    public static void main(String[] args) {
        printYearsAndDays(525600);
        printYearsAndDays(1051200);
        printYearsAndDays(561600);
        printYearsAndDays(0);
    }
}
