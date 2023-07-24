import java.util.Random;

public class TryTheEnum {

    public static void main(String[] args) {
        DayOfTheWeek weekDay = DayOfTheWeek.THURS;
        System.out.println(weekDay);

        for (int i = 0; i < 10; i++) {
            weekDay = getRandomDay();
//            System.out.printf("Name is %s, Ordinal Value = %d%n",
//                    weekDay.name(), weekDay.ordinal()
//            );
//
//            if (weekDay == DayOfTheWeek.FRIDAY) {
//                System.out.println("It's Friday!!!");
//            }

            switchDayOfWeek(weekDay);
        }

        for (Topping t : Topping.values()) {
            System.out.println(t.name() + " : " + t.getPrice());
        }
    }

    private static void switchDayOfWeek(DayOfTheWeek weekDay) {
        int weekDayInteger = weekDay.ordinal() + 1;
        switch (weekDay) {
            case SATUR -> System.out.println("Wednesday is day " + weekDayInteger);
            case WEDNES -> System.out.println("Wednesday is day " + weekDayInteger);
            default -> System.out.println(
                    weekDay.name().charAt(0) +
                            weekDay.name().substring(1).toLowerCase() +
                            "day is Day " + weekDayInteger
            );
        }
    }

    private static DayOfTheWeek getRandomDay() {
        int randInt = new Random().nextInt(7);
        var allDays = DayOfTheWeek.values();

        return allDays[randInt];
    }
}