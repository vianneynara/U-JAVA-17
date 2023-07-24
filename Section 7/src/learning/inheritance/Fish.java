package learning.inheritance;

public class Fish extends Animal {
    private int gills;
    private int fins;

    public Fish(String type, double weight, int gills, int fins) {
        super(type, "small", weight);
        this.gills = gills;
        this.fins = fins;
    }

    private void moveMuscles() {
        System.out.print("Muscles Moving ");
    }

    private void moveBackFin() {
        System.out.print("Backfin Moving ");
    }

    @Override
    public void move(String speed) {
        super.move(speed);
        moveMuscles();
        if (speed == "fast") moveBackFin();
        System.out.println();
    }

    @Override
    public String toString() {
        return "learning.inheritance.Fish{" +
                "gills=" + gills +
                ", fins=" + fins +
                "} " + super.toString();
    }
}
