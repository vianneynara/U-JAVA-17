package challenges;

public class PlayingCat {
    public static boolean isCatPlaying(boolean summer, int temperature) {
        if (!summer) {
            return temperature >= 25 && temperature <= 35;
        } else return temperature >= 25 && temperature <= 45;
    }

    public static void main(String[] args) {
        System.out.println(isCatPlaying(false, 45));
    }
}
