public abstract class Animal {
    /**
     * Abstract class can't be called directly, rather being called by its subclasses.
     * */
    protected String type;
    private String size;
    private double weight;

    public Animal(String type, String size, double weight) {
        this.type = type;
        this.size = size;
        this.weight = weight;
    }

    public abstract void move(String speed);
    public abstract void makeNoise();

    // final methods cannot be overridden.
    public final String getExplicitType() {
        return getClass().getSimpleName() + " (" + type + ")";
    }
}

/**
 * Abstract class doesn't have to implement abstract methods.
 * */
abstract class Mammal extends Animal {

    public Mammal(String type, String size, double weight) {
        super(type, size, weight);
    }

    @Override
    public void move(String speed) {
        System.out.println(getExplicitType() + " " + (speed.equals("slow") ? "walks" : "run"));
    }

    public abstract void shedHair();
}
