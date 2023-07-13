package sri.examples.collections.Enums;

import java.util.*;

/*
Two more classes in the collections framework, specifically created to support enum types more efficiently. You can use any List, Set, or Map, with an enum constant. The EnumSet, and EnumMap, each has a special implementation that differs from the HashSet or HashMap.

These implementations make these two types extremely compact and efficient. There's no special list implementation for enum types.
======================================EnumSet==============================
The EnumSet is a specialized Set implementation for use with enum values. All the elements in an EnumSet must come from a single enum type.

The EnumSet is abstract, meaning we can't instantiate it directly. It comes with many factory methods to create instances.

In general, this set has much better performance than using a HashSet, with an enum type.

Bulk operations (such as containsAll and retainAll) should run very quickly, in constant time, O(1), if they're run on an enumSet, and their argument is an EnumSet.

======================================Enum Map==============================
The Enum Map is a specialized Map implementation for use with enum type keys.

The keys must all come from the same enum type, and they're ordered naturally by the ordinal value of the enum constants.

This map has the same functionality as a HashMap, with O(1) for basic operations.

The enum key type is specified during construction of the EnumMap, either explicitly by passing the key type's class, or implicitly by pass another EnumSet.

In general, this map has better performance than using a HashMap, with an enum type.

Let's review some of the things you can do when you combine enums with these collections.
 */
public class EnumSetEnumMap {
    enum WeekDay{SUNDAY,MONDAY,TUESDAY,WEDNESDAY,THURSDAY,FRIDAY,SATURDAY}
    public static void main(String[] args) {
        List<WeekDay> annsWorkDays=new ArrayList<>(List.of(WeekDay.MONDAY,WeekDay.TUESDAY,WeekDay.THURSDAY,WeekDay.FRIDAY));
        var annsDaysSet= EnumSet.copyOf(annsWorkDays);
        System.out.println(annsDaysSet.getClass().getSimpleName());

        /// Two types of EnumSet implementations
        //Enum sets are represented internally as bit vectors, which is just a series of ones and zeros.
        //A one indicates that the enum constant (with an ordinal value that is equal to the index of the bit) is in the set.
        //A zero indicates the enum constant is not in the set.
        //Using a bit vector allows all set operations to use bit math, which makes it very fast. A RegularEnumSet uses a single long as its bit vector, which means it can contain a maximum of 64 bits, representing 64 enum values.
        //A JumboEnumSet gets returned if you have more than 64 enums.
        System.out.println("_____________________________________________");
        annsDaysSet.forEach(System.out::println);

        var allDaysSet=EnumSet.allOf(WeekDay.class);
        System.out.println("_____________________________________________");
        allDaysSet.forEach(System.out::println);
        System.out.println("_____________________________________________");
        Set<WeekDay> newPersonDays=EnumSet.complementOf(annsDaysSet);
        newPersonDays.forEach(System.out::println);
        System.out.println("_____________________________________________");
        Set<WeekDay> businessDays=EnumSet.range(WeekDay.MONDAY,WeekDay.FRIDAY);
        businessDays.forEach(System.out::println);


        /// Enum Map
        //This class is not abstract, so I can create an instance of it directly using new, but unlike other Map implementations, it doesn't have a no args constructor.
        //I'll create a map, keyed by Week day, and each mapped element will be an array of string.
        //That array will be the names of my employees who work those days.
        //I'll assign that a new EnumMap instance, and pass it the WeekDay.class

        Map<WeekDay,String[]> employeeMap=new EnumMap<>(WeekDay.class);
        employeeMap.put(WeekDay.FRIDAY,new String[]{"Ann","Mary","Bob"});
        employeeMap.put(WeekDay.MONDAY,new String[]{"Mary","Bob"});
        employeeMap.forEach((k,v)->System.out.println(k+": "+Arrays.toString(v)));

    }
}
