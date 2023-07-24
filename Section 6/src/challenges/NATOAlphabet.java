package challenges;

public class NATOAlphabet {
    public static String getNATOWord(char alphabet) {
        return switch (alphabet) {
            case 'A': yield "Able";
            case 'B': yield "Baker";
            case 'C': yield "Charlie";
            case 'D': yield "Dog";
            case 'E': yield "Easy";
            default: yield "Character " + alphabet + " not found";
        };
    }

    public static void main(String[] args) {
        System.out.println(getNATOWord('Z'));
    }
}
