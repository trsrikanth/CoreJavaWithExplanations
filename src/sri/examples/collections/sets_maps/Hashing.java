package sri.examples.collections.sets_maps;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Hashing {
    public static void main(String[] args) {
        String aText="Hello";
        String bText="Hello";
        String cText=String.join("l","He","lo");
        String dText="He".concat("llo");
        String eText="hello";
        List<String> hellos= Arrays.asList(aText,bText,cText,dText,eText);
        //Notice that all 4 of the Strings with a capital h, return the exact same hash code,
        // but the last one is different. Java doesn't care if these are
        //different objects in memory, when it tests the equality of Strings, using the equals method.
        //It just cares that the characters match, in one instance, compared to another instance.
        hellos.forEach(s-> System.out.println(s+" : "+s.hashCode()));

        /*
        A hash set is a class that implements the Set interface, and tracks duplicates by their hash code.
        Most collections allow the creation of another collection type,
        by passing a different collection to the constructor, as I'm doing here,
        passing a list to a set, but a Set's constructor allows any instance
        that implements Collection to be passed to it.
         */
        Set<String> mySet=new HashSet<>(hellos);
        System.out.println("My set "+mySet);
        System.out.println("# of elements in the set = "+mySet.size());
        // You can see the number of elements = 2,
        //even though the list I passed to the constructor, had 5 references.

        for(String setValue:mySet){
            System.out.print(setValue+": ");
            for(int i=0;i<hellos.size();i++){
                if(setValue==hellos.get(i)){
                    System.out.print(i+", ");
                }
            }
            System.out.println(" ");
        }
        //Hello, with an uppercase H, is the same reference as the first two list elements, at index 0 and 1.
        //The hello element with lower case is the last element in the Strings list.
        //The hash set will only add new references to its collection if it doesn't find a match inits collection,
        //first using the hashCode and then the object's equals method.
        //It uses the hashCode to create a bucket identifier to store the new reference.

    }
}
