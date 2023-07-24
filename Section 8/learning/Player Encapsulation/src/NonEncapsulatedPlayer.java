public class NonEncapsulatedPlayer {
    public String name;
    public int health;
    public String weapon;

//    public Player(String name, int health, String weapon) {
//        this.name = name;
//        this.health = health;
//        this.weapon = weapon;
//    }

    public void loseHealth(int damage) {
        health -= ((health - damage) < 0) ? 0 : damage;
        if (health <= 0) {
            System.out.println("Player knocked out");
        }
    }

    public void restoreHealth(int extraHealth) {
        health += ((health + extraHealth) >= 100) ? 100 : extraHealth;
        if (health < 100) {
            System.out.println("Player health has been restored");
        } else {
            System.out.println("Player health has been fully restored");
        }
    }

    public int healthRemaining() {
        return health;
    }
}
