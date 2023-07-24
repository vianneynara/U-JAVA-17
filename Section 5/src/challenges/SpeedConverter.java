package challenges;

public class SpeedConverter {
    public static long toMilesPerHour(double kilometersPerHour) {
        long converted = Math.round(kilometersPerHour / 1.609);
        if (converted < 0) return -1;
        return converted;
    }
    public static void printConversion(double kilometersPerHour) {
        long milesPerHour = toMilesPerHour(kilometersPerHour);
        if (milesPerHour < 0) System.out.println("Invalid Value");
        else {
            System.out.println(kilometersPerHour + " km/h = " + milesPerHour + " mi/h");
        }
    }
    public static void main(String[] args) {
        printConversion(1.5);
        printConversion(10.25);
        printConversion(-5.6);
    }
}
