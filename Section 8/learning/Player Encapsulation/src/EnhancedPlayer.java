public class EnhancedPlayer {
    private String name;
    private int MAX_HEALTH = 100;
    private int health;
    private String weapon;

    public EnhancedPlayer(String name) {
        this.name = name;
        this.health = MAX_HEALTH;
        this.weapon = "Sword";
    }

    public EnhancedPlayer(String name, int health, String weapon) {
        this.name = name;
        this.health = (health <= 0) ? 1 : Math.min(health, 100);
        this.weapon = weapon;
    }


    public void loseHealth(int damage) {
        health -= ((health - damage) < 0) ? 0 : damage;
        if (health <= 0) {
            System.out.println("Player knocked out");
        }
    }

    public void restoreHealth(int extraHealth) {
        health += ((health + extraHealth) <= MAX_HEALTH) ? extraHealth : (MAX_HEALTH - health);
        if (health < MAX_HEALTH) {
            System.out.println("Player health has been restored");
        } else {
            System.out.println("Player health has been fully restored");
        }
    }

    public int healthRemaining() {
        return health;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public String getWeapon() {
        return weapon;
    }
}
