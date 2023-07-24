package challenges;

public class LeapYear {
    public static boolean isLeapYear(int year) {
        if ((year >= 1) && (year <= 9999)) {
            return ((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0);
        }
        else return false;
    }

//    public static boolean isLeapYear(int year) {
//        if (!(year >= 1 && year <= 9999)) return false; // year not in range
//        else if (year % 4 == 0) {
//            if (year % 100 == 0) {
//                if (year % 400 == 0) return true;
//                return false;
//            }
//            return true;
//        }
//        else return false;
//    }

    public static void main(String[] args) {
        System.out.println(isLeapYear(-1600));
        System.out.println(isLeapYear(1600));
        System.out.println(isLeapYear(2017));
        System.out.println(isLeapYear(2000));
    }
}
