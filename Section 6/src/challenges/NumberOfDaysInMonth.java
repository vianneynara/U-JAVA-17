package challenges;

public class NumberOfDaysInMonth {
    public static boolean isLeapYear(int year) {
        if (!(year >= 1 && year <= 9999)) {
            return false;
        }
        else return ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0);
    }

//    public static int getDaysInMonth(int month, int year) {
//        if (month < 1 || month > 12 || year < 1 || year > 9999) return -1;
//
//        return switch (month) {
//            case 4, 6, 9, 11:
//                yield 30;
//            case 2:
//                if (isLeapYear(year)) yield 29;
//                yield 28;
//            default: yield 31;
//        };
//    }

    public static int getDaysInMonth(int month, int year) {
        if (month < 1 || month > 12 || year < 1 || year > 9999) return -1;

        switch (month) {
            case 4: case 6: case 9: case 11:
                return 30;
            case 2:
                if (isLeapYear(year)) return 29;
                return 28;
            default: return 31;
        }
    }

    public static void main(String[] args) {
        System.out.println(getDaysInMonth(2, 2020));
    }
}
