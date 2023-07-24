package learning.inheritance;

public class Dog extends Animal {
    private String earShape, tailShape;
    public Dog() {
        super("Mutt", "Big", 50); // has to be the first statement
    }

    public Dog(String type, double weight) {
        this(type, weight, "Perky", "Curled");
    }
    public Dog(String type, double weight, String earShape, String tailShape) {
        super(
                type,
                (weight < 15 ? "small" : (weight < 35) ? "medium" : "large"), // size
                weight
        );
        this.earShape = earShape;
        this.tailShape = tailShape;
    }

    @Override
    public String toString() {
        return "learning.inheritance.Dog{" +
                "earShape='" + earShape + '\'' +
                ", tailShape='" + tailShape + '\'' +
                "} " + super.toString();
    }

    @Override
    public void makeNoise() {
        if (type == "Wolf") {
            System.out.print("Ow Woooooo! ");
        }
        bark();
    }

    @Override
    public void move(String speed) {
        super.move(speed);
//        System.out.println("Dogs walk, run, and wag their tail");
        if (speed == "slow") {
            walk();
            wagTail();
        } else {
            run();
            bark();
        }
        System.out.println();
    }

    private void bark() {
        System.out.println("Woof! ");
    }

    private void run() {
        System.out.println("learning.inheritance.Dog Running ");
    }

    private void walk() {
        System.out.println("learning.inheritance.Dog Walking");
    }

    private void wagTail() {
        System.out.println("Tail Wagging ");
    }
}
