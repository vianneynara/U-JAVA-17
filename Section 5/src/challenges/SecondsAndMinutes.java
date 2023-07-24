package challenges;

public class SecondsAndMinutes {
    public static String getDurationString(int seconds) {
        if (!(seconds >= 0)) {
            System.out.println("Minimum seconds value should be 0.");
            return "ConversionError";
        }
        else {
            int minutes = seconds / 60;
            int hours = minutes / 60;

            int remainingMinutes = minutes % 60;
            int remainingSeconds = seconds % 60;

            return hours + "h " + remainingMinutes + "m " + remainingSeconds + "s";

//            int hours = seconds / 3600;
//            int minutes = (seconds / 60) - (hours * 60);
//            seconds -= ((minutes * 60) + (hours * 3600));
//
//            return hours + "h " + minutes + "m " + seconds + "s";
        }
    }

    public static String getDurationString(int minutes, int seconds) {
        if (!(minutes >= 0)) {
            System.out.println("Minimum minutes value should be 0.");
            if (!(seconds >= 0 && seconds <= 59)) System.out.println("Minimum seconds value should be in the range of 0 to 59.");
            return "ConversionError";
        }
        else {
            seconds += (minutes * 60);
            return getDurationString(seconds);
        }
    }

    public static void main(String[] args) {
        System.out.println(getDurationString(8274));
        System.out.println(getDurationString(137, 54));
    }
}
