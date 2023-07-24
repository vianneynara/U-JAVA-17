public class Main {
    public static void main(String[] args) {
        EnhancedPlayer player1 = new EnhancedPlayer("Desmos", 200, "Bow");
        playerInfo(player1);

        player1.loseHealth(15);
        System.out.println("Remaining health: " + player1.healthRemaining());

        player1.loseHealth(35);
        System.out.println("Remaining health: " + player1.healthRemaining());

        player1.restoreHealth(55);
        System.out.println("Remaining health: " + player1.healthRemaining());
    }

    private static void playerInfo(EnhancedPlayer player) {
        System.out.printf("""
                Showing player information
                Name    : %s
                Health  : %d
                Weapon  : %s
                --------------------------
                
                """, player.getName(), player.getHealth(), player.getWeapon());
    }
}
