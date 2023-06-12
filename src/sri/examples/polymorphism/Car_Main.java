package sri.examples.polymorphism;

public class Car_Main {
    public static void main(String[] args) {

        Car car = new Car("2022 Blure Ferari 296 GTS");
        runRace(car);

        Car ferari = new GasPoweredCar("2022 Blure Ferari 296 GTS",15.4,6);
        runRace(ferari);

        Car tesla = new ElectricCar("2022 Red Tesla Modle 3",568,75);
        runRace(tesla);
    }

    public static void runRace(Car car){
        car.startEngine();
        car.drive();
    }
}
