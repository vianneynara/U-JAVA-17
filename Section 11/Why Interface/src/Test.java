public class Test {

    private static void inFlight(FlightEnabled flier) {
        flier.fly();
        flier.transition(FlightStages.LAUNCH);
        if (flier instanceof Trackable tracked) {
            tracked.track();
        }
        flier.land();

    }
    private static void orbit(OrbitEarth flier) {
        flier.fly();
        flier.achieveOrbit();
        flier.land();

    }
    public static void main(String[] args) {
        inFlight(new Rocket());

//        OrbitEarth.log("Testing " + new Rocket());

        orbit(new Satellite());
    }
}
