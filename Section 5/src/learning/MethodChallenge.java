package learning;

public class MethodChallenge {
    private static void displayHighScorePosition(String playerName, byte playerPosition) {
        System.out.println(playerName + " managed to get into position " + playerPosition + " on the high score list");
    }
    private static byte calculateHighScorePosition(int playerScore) {
        byte position;

        if (playerScore >= 1000) position = 1;
        else if (playerScore >= 500) position = 2;
        else if (playerScore >= 100) position = 3;
        else position = 4;

        return position;
    }
    public static void main(String[] args) {
        displayHighScorePosition("Player 1", calculateHighScorePosition(1500));
        displayHighScorePosition("Player 2", calculateHighScorePosition(1000));
        displayHighScorePosition("Player 3", calculateHighScorePosition(500));
        displayHighScorePosition("Player 4", calculateHighScorePosition(100));
        displayHighScorePosition("Player 5", calculateHighScorePosition(25));
    }
}
