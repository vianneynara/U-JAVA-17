package learning.stringbuilders;

public class StringBuildersMain {
    public static void main(String[] args) {
        String helloWorld = "Hello" + " World";
        helloWorld.concat("!");
        // helloWorld = helloWorld.concat("!");

        StringBuilder helloWorldBuilder = new StringBuilder("Hello" + " World");
        helloWorldBuilder.append("!");

        printInformation(helloWorld);
        printInformation(helloWorldBuilder);
        System.out.println();

        StringBuilder emptySB = new StringBuilder();
        emptySB.append("a".repeat(57));
        StringBuilder emptySB32 = new StringBuilder(32);
        emptySB32.append("a".repeat(17));

        printInformation(emptySB);
        printInformation(emptySB32);

        StringBuilder builderPlus = new StringBuilder("Hello" + " World");
        builderPlus.append("!");
        builderPlus.deleteCharAt(11).insert(11, '?');
        builderPlus.replace(2, 3, "1");
        builderPlus.reverse().setLength(7);

        printInformation(builderPlus);
    }
    public static void printInformation(String string) {
        System.out.println("string: " + string);
        System.out.println("length: " + string.length());

        System.out.println("_ ".repeat(10));
    }
    public static void printInformation(StringBuilder builder) {
        System.out.println("string: " + builder);
        System.out.println("length: " + builder.length());
        System.out.println("length: " + builder.capacity());

        System.out.println("_ ".repeat(10));
    }
}
