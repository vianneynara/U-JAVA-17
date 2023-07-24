public class Main {
    public static void main(String... args) {
        System.out.println("Hello World again");
        String[] splitStrings = "Hello World again".split(" ");
        printText(splitStrings);

        System.out.println("_".repeat(20));
        printText("HeLlO", "wORld", "AgAIn");

        System.out.println("_".repeat(20));
        printText();

        String[] sArr = {"satu", "dua", "tiga", "empat", "lima"};
        System.out.println(String.join(", ", sArr));
    }

    private static void printText(String... textList) {
        for(String text: textList) {
            System.out.println(text);
        }
    }
}
