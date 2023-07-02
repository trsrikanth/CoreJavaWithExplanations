package sri.examples.abstraction.abstractClass;

import java.util.ArrayList;

public class   Main {
    public static void main(String[] args) {
        //Animal animal = new Animal("animal","big",100); // we cannot instantiate abstract class
        Dog dog = new Dog("Wolf","big",100);
        dog.makeNoise();
        doAnimalStuff(dog);

        ArrayList<Animal> animals = new ArrayList<>();
        animals.add(dog);
        animals.add(new Dog("German Shepard","big",150));
        animals.add(new Fish("Gold fish","small",1));
        animals.add(new Fish("Barracuda","big",75));
        animals.add(new Dog("Pug","small",20));

        animals.add(new Horse("Clydesdale","large",1000));

        for(Animal animal:animals){
            doAnimalStuff(animal);
            if(animal instanceof  Mammal currentMammal){
                //animal.shedHair();  //this code will not even compile animal is of animal type and method shedHair is not on animal class
                currentMammal.shedHair();
            }
        }
    }

    public static void doAnimalStuff(Animal animal){
        animal.makeNoise();
        animal.move("slow");
    }
}
