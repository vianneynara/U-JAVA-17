import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class InterfaceMain {

    public static void inFlight(FlightEnabled flier) {

        flier.fly();
    }

    /** Using ArrayList. This can only be implemented by ArrayList variables. */
//    public static void flyFliers(ArrayList<FlyingEnabled> fliers) {
//
//        for (var flier : fliers) {
//            flier.fly();
//        }
//    }

    /** (better) Using List (an interface implemented by ArrayList, Array, LinkedList, etc.). Can be implemented by any class that implements List. */
    public static void flyFliers(List<FlightEnabled> fliers) {

        for (var flier : fliers) {
            flier.fly();
        }
    }

    public static void main(String[] args) {
        Bird animal = new Bird();
        FlightEnabled bird = animal;

        inFlight(animal);
        inFlight(bird);

        //

        ArrayList<FlightEnabled> flock = new ArrayList<>();
        flock.add(bird);

        List<FlightEnabled> birds = new LinkedList<>();
        birds.add(bird);

        flyFliers(flock);
        flyFliers(birds);
    }
}
