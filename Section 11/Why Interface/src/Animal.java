public abstract class Animal {

    abstract void move();
}

class Bird extends Animal implements FlightEnabled, Trackable {

    @Override
    void move() {
        System.out.print(getClass().getSimpleName() + " is moving");
    }

    @Override
    public void takeOff() {
        System.out.println(getClass().getSimpleName() + " is taking off");
    }

    @Override
    public void fly() {
        System.out.println(getClass().getSimpleName() + " is flying");
    }

    @Override
    public void land() {
        System.out.println(getClass().getSimpleName() + "is landing");
    }

    @Override
    public void track() {
        System.out.println(getClass().getSimpleName() + "'s coordinates recorded");
    }
}