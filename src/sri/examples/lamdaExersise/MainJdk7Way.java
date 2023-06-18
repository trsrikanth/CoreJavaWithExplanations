package sri.examples.lamdaExersise;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class MainJdk7Way {
    public static void main(String[] args) {
        List<Person> people =  Arrays.asList(new Person("Charlies","Dicknes",40),
                new Person("Srikanth","Reddy",43),
                new Person("Tim","Blake",62),
                new Person("Akbar","Uddin",58),
                new Person("Shankar","Singh",16),
                new Person("Ram","Mohan",32));



        Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getLname().compareTo(o2.getLname());
            }
        });

        printAll(people);

        System.out.println("-".repeat(8));
        printConditionally(people, new Condition() {
            @Override
            public boolean test(Person p) {
                return p.getLname().startsWith("R");
            }
        });

    }

    private static void printConditionally(List<Person> people,Condition condition) {
        for (Person person:people){
            if(condition.test(person)){
                System.out.println(person);
            }
        }
    }

    private static void printAll(List<Person> people){
        for (Person person:people){
            System.out.println(person);
        }
    }
}
interface Condition{
    boolean test(Person p);
}
