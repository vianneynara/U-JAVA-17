public class Satellite implements OrbitEarth, Trackable {

    FlightStages stage = FlightStages.GROUNED;

    @Override
    public void achieveOrbit() {
        transition(getClass().getSimpleName() + " achieved orbit!");
    }

    @Override
    public void takeOff() {
        transition("Taking off");
    }

    @Override
    public void fly() {
        achieveOrbit();
        transition("Data collection while orbiting");
    }

    @Override
    public void land() {
        transition("Landing");
    }

    @Override
    public void track() {
        System.out.println(getClass().getSimpleName() + "'s coordinates recorded");
    }

    public void transition(String description) {
        System.out.println(description);
        stage = transition(stage);
        stage.track();
    }
}
