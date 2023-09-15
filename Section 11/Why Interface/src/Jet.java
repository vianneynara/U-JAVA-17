public class Jet implements FlightEnabled, Trackable {

    @Override
    public void takeOff() {
        System.out.println(getClass().getSimpleName() + " is taking off");
    }

    @Override
    public void fly() {
        System.out.print(getClass().getSimpleName() + " is flying");
    }

    @Override
    public void land() {
        System.out.println(getClass().getSimpleName() + "is landing");
    }

    @Override
    public void track() {
        System.out.print(getClass().getSimpleName() + "'s coordinates recorded");
    }
}
