package sri.examples.abstraction.interfaceDemo;

enum FlightStages implements Trackable {GROUNDED,LAUNCH,CRUISE,DATA_COLLETION;

    @Override
    public void track() {
        if(this !=GROUNDED){
            System.out.println("Monitoring "+this);
        }
    }

    public FlightStages getNextStages(){
        FlightStages[] allStages=values();
        return allStages[(ordinal()+1)%allStages.length];

    }
}
record DragonFly(String name,String type) implements FlightEnabled{

    @Override
    public void takeOff() {

    }

    @Override
    public void land() {

    }

    @Override
    public void fly() {

    }
}
class Satellite implements OrbitEarth{

    FlightStages stage= FlightStages.GROUNDED;

    @Override
    public void achieveOrbit() {
        transition("Orbit achieved");
    }

    @Override
    public void takeOff() {
        transition("Taking off..");
    }

    @Override
    public void land() {
        transition("Landing");
    }

    @Override
    public void fly() {
        achieveOrbit();
        transition("Data collection while orbiting");
    }

    public void transition(String description){
        System.out.println(description);
        stage = transition(stage);
        stage.track();
    }
}

interface OrbitEarth extends FlightEnabled{
    void achieveOrbit();

    // public static methods included from jdk8
    // for example Comparator.naturalOrder() and Comparator.reverseOrder() from jdk8 are examples

    /*
    static void log (String description){
        var today=new java.util.Date();
        System.out.println(today+": "+description);
    }
*/
    // jdk9 gave private static and not static methods on interfaces
    //This enhancement primarily addresses the problem of re-use of code, within concrete methods on interface.
    //private static methods can be accessed by either a public static method, a default method, or a
    // private non-static method.
    //A private non-static method is used to support default methods, and other private methods.

    private static void log (String description){
        var today=new java.util.Date();
        System.out.println(today+": "+description);
    }

    private void logStage(FlightStages stage,String description){
        description = stage + ": "+description;
        log(description);
    }

    @Override
    default FlightStages transition(FlightStages stage) {
        FlightStages nextStage = FlightEnabled.super.transition(stage);
        logStage(stage,"Beginning Transition to "+nextStage);
        return nextStage;
    }
}

interface FlightEnabled{
    public static final double MILES_TO_KMS=1.60934;
    double KMS_TO_MILES=0.621371;

     void takeOff();
     void land();
    void fly();

    // default methods in interfaces from java8 onwards
    default FlightStages transition(FlightStages stage){
        /*System.out.println("transition not implemented on "+getClass().getName());
        return null;*/
        FlightStages nextStage=stage.getNextStages();
        System.out.println("Transition from "+ stage +" to "+nextStage);
        return nextStage;
    }
}
interface Trackable{
    void track();
}
public abstract class Animal {
    public abstract void move();


}
