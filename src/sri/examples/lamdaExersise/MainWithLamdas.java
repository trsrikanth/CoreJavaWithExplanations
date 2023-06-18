package sri.examples.lamdaExersise;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class MainWithLamdas {
    public static void main(String[] args) {
        List<Person> people =  Arrays.asList(new Person("Charlies","Dicknes",40),
                new Person("Srikanth","Reddy",43),
                new Person("Tim","Blake",62),
                new Person("Akbar","Uddin",58),
                new Person("Shankar","Singh",16),
                new Person("Ram","Mohan",32));



        Collections.sort(people,( o1,  o2) -> o1.getLname().compareTo(o2.getLname()));

        printConditionally(people,p->Boolean.TRUE);

        System.out.println("-".repeat(8));
        printConditionally(people, (Person p) -> p.getLname().startsWith("R"));

    }

    private static void printConditionally(List<Person> people,Condition condition) {
        for (Person person:people){
            if(condition.test(person)){
                System.out.println(person);
            }
        }
    }


}

