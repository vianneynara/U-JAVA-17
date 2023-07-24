package challenges;

public class FeetToCentimeter {
    public static double convertToCentimeters(int inches) {
        return inches * 2.54;
    }

//    public static double convertToCentimeters(int feet, int inches) {
//        return (feet * 30.48) + convertToCentimeters((int) (inches % 30.48));
//    }

    public static double convertToCentimeters(int feet, int inches) {
        return convertToCentimeters((int) ((feet * 12) + (inches % 30.48)));
    }

    public static void main(String[] args) {
        System.out.println(convertToCentimeters(5));
        System.out.println(convertToCentimeters(5, 7));
    }
}
