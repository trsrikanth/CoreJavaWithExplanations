package sri.examples.abstraction.interfaceDemo;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Bird bird = new Bird();
        Animal animal=bird;
        FlightEnabled flightEnabled=bird;
        Trackable trackable=bird;



        inFlight(flightEnabled);

        inFlight(new Jet());

        Truck truck = new Truck();
        truck.track();

        double kmsTravled=100;
        double milesTraveled=kmsTravled*FlightEnabled.KMS_TO_MILES;

        System.out.printf("The truck traveled %.2f km or %.2f miles%n",kmsTravled,milesTraveled);

        ArrayList<FlightEnabled> fliers=new ArrayList<>(); // this is not an effecient way to code always try to code
        fliers.add(bird);                                   // taking interfaces in mind

        List<FlightEnabled> betterFliers=new ArrayList<>(); // as we are coding to interfaces its better way of coding
        betterFliers.add(bird);                             // in future we can easily switch from arraylist to linkedlist easily

    }

    private static void inFlight(FlightEnabled flier){
        flier.takeOff();
        flier.fly();
        if(flier instanceof Trackable tracked){
            tracked.track();
        }
        flier.land();
    }
}
