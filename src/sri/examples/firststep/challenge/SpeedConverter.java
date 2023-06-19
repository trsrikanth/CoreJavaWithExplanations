package sri.examples.firststep.challenge;

/*
1. Write a method called toMilesPerHour that has 1 parameter of type double with the name kilometersPerHour. This method needs to return the rounded value of the calculation of type long.
If the parameter kilometersPerHour is less than 0, the method toMilesPerHour needs to return -1 to indicate an invalid value.
Otherwise, if it is positive, calculate the value of miles per hour, round it and return it. For conversion and rounding, check the notes in the text below.

Examples of input/output:
* toMilesPerHour(1.5); → should return value 1
* toMilesPerHour(10.25); → should return value 6
* toMilesPerHour(-5.6); → should return value -1
* toMilesPerHour(25.42); → should return value 16
* toMilesPerHour(75.114); → should return value 47
 */
public class SpeedConverter {
    public static long toMilesPerHour(double kilometersPerHour){
        long milesPerHour =-1;
        if(kilometersPerHour>-1){
            milesPerHour = Math.round(kilometersPerHour/1.609);
        }
        return milesPerHour;
    }

    public static void printConversion(double kilometersPerHour){
        long milesPerHour = toMilesPerHour(kilometersPerHour);

        if(milesPerHour==-1){
            System.out.println("Invalid Value");
        }else {
            System.out.println(kilometersPerHour+ " km/h = " + milesPerHour +" mi/h");
        }
    }
}
