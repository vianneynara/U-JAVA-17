package learning.playingwithstrings;

public class StringMethodsMain {
    public static void main(String[] args) {
        printInfomation("Hello World!");
        printInfomation("");
        printInfomation("\t \n ");

        String helloWorld = "HelloWorld";
        System.out.printf("index of r = %d %n", helloWorld.indexOf('r'));

        System.out.printf("index of World = %d %n", helloWorld.indexOf("World"));

        System.out.printf("index of l = %d %n", helloWorld.indexOf('l')); // first l

        System.out.printf("index of l = %d %n", helloWorld.lastIndexOf('l')); // last l

        System.out.printf("index of l = %d %n", helloWorld.indexOf('l', 3)); // search first from index 3

        System.out.printf("index of l = %d %n", helloWorld.lastIndexOf('l', 8)); // search last from index 8

        String helloWorldLower = helloWorld.toLowerCase();
        if (helloWorld.equals(helloWorldLower)) System.out.println("Values match");
        if (helloWorld.equalsIgnoreCase(helloWorldLower)) System.out.println("Values match ignoring case");
        if (helloWorld.startsWith("Hello")) System.out.println("Starts with Hello");
        if (helloWorld.endsWith("World")) System.out.println("Ends with World");
        if (helloWorld.contains("orl")) System.out.println("String contains orl");


        if (helloWorld.contentEquals("Hello World")) System.out.println("Values match exactly");
    }

    public static void printInfomation(String string) {
        int length = string.length();

        System.out.printf("Length\t\t: %d %n", length);
        if (string.isEmpty()) {
            System.out.println("String is empty");
            System.out.println("_ _ _ _ _");
            return;
        }
        if (string.isEmpty()) {
            System.out.println("String is blank");
        }

        System.out.printf("First Char\t: %c %n", string.charAt(0));

        System.out.printf("Last Char\t: %c %n", string.charAt(length - 1));

        System.out.println("_ _ _ _ _");
    }
}
