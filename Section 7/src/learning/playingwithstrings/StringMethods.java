package learning.playingwithstrings;

public class StringMethods {
    public static void main(String[] args) {
        //           index  0123456789
        String birthDate = "25/11/1982";
        System.out.println("original date\t: " + birthDate);
        int startingIndex = birthDate.indexOf("1982");
        System.out.println("starting index\t: " + startingIndex);
        System.out.println("birth year\t\t: " + birthDate.substring(startingIndex));
        System.out.println("birth month\t\t: " + birthDate.substring(3, 5));
        System.out.println("birth day\t\t: " + birthDate.substring(0, 2));

        String newDate = String.join("-", "25", "11", "1982");
        System.out.println("new date\t\t: " + newDate);

        newDate = "25".concat("\\"); // reassign date
        newDate = newDate.concat("11");
        newDate = newDate.concat("\\").concat("1982");
        System.out.println("concatenated\t: " + newDate);

        System.out.println("replaced -> " + newDate.replace('\\', '_'));
        System.out.println("replaced -> " + newDate.replace("2", "(two)"));
        System.out.println("replaced -> " + newDate.replaceFirst("1", "(one)")); // replaces only the first "1"
        System.out.println("replaced -> " + newDate.replaceAll("2", "(two)")); // replaces only the first "2"
        System.out.println("replaced -> " + newDate.replaceAll("\\d", "x")); // replaces only the first "2"

        System.out.println();
        System.out.println("""
                Wek
                wek:
                    \u2022 wek
                """
        );
        System.out.println("ABC\n".indent(5).repeat(3));
        System.out.println("<> ".repeat(10));

        System.out.println("     ABC\n".indent(-2).repeat(3));
        System.out.println("<> ".repeat(10));
    }
}
