enum FlightStages implements Trackable {
    GROUNED, LAUNCH, CRUISE, DATA_COLLECTION;

    @Override
    public void track() {
        if (this != GROUNED)
            System.out.println("Monitoring " + this);
    }

    public FlightStages getNextStage() {

        FlightStages[] allStages = values();
        return allStages[(ordinal() + 1) % allStages.length];
    }
}

public class Rocket implements FlightEnabled, Trackable {

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
        System.out.print(getClass().getSimpleName() + "'s coordinates recorded");
    }

    @Override
    public FlightStages transition(FlightStages stage) {
        System.out.println(getClass().getSimpleName() + " transitioning");
        return FlightEnabled.super.transition(stage);
    }
}
