package sri.examples.general.challenges;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//https://www.baeldung.com/java-stream-sum
public class SummingNumbersStreams {
    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        int sum=0;

        //Stream.reduce() is a terminal operation that performs a reduction on the elements of the stream.
        //It applies a binary operator (accumulator) to each element in the stream, where the first operand is the return value of the previous application, and the second one is the current stream element.
        //In the first method of using the reduce() method, the accumulator function is a lambda expression that adds two Integer values and returns an Integer value:

        sum = integers.stream()
                .reduce(0, (a, b) -> a + b);
        System.out.println("Sum of the elements in the array :"+integers+" is "+sum);

        //In the same way, we can use an already existing Java method:
        sum = integers.stream()
                .reduce(0, Integer::sum);


        // we can define and use our custom method, Then we can pass this function as a parameter to the reduce() method:

        sum = integers.stream()
                .reduce(0, ArithmeticUtils::add);

        //Using Stream.collect()
        //The second method for calculating the sum of a list of integers is by using the collect() terminal operation:
        //Similarly, the Collectors class provides summingLong() and summingDouble() methods to calculate the sums of longs and doubles, respectively.

        sum = integers.stream()
                .collect(Collectors.summingInt(Integer::intValue));

        // Using IntStream.sum()
        //The Stream API provides us with the mapToInt() intermediate operation, which converts our stream to an IntStream object.
        //This method takes a mapper as a parameter, which it uses to do the conversion, then we can call the sum() method to calculate the sum of the stream's elements.

        sum = integers.stream()
                .mapToInt(Integer::intValue)
                .sum();


        //Using Stream#sum With Map
        //To calculate the sum of values of a Map<Object, Integer> data structure, first we create a stream from the values of that Map. Next we apply one of the methods we used previously.

        /*sum = map.values()
                .stream()
                .mapToInt(Integer::valueOf)
                .sum();*/


        //6. Using Stream#sum With Objects

        //Let's imagine that we have a list of objects and that we want to calculate the sum of all the values of a given field of these objects.

        Item item1 = new Item(1, 10);
        Item item2 = new Item(2, 15);
        Item item3 = new Item(3, 25);
        Item item4 = new Item(4, 40);

        List<Item> items = Arrays.asList(item1, item2, item3, item4);

        //In this case, in order to calculate the sum using the methods shown in previous examples, we need to call the map() method to convert our stream into a stream of integers.
        //As a result, we can use Stream.reduce(), Stream.collect(), and IntStream.sum() to calculate the sum:

        sum = items.stream()
                .map(x -> x.getPrice())
                .reduce(0, ArithmeticUtils::add);

        sum = items.stream()
                .map(x -> x.getPrice())
                .reduce(0, Integer::sum);

        sum = items.stream()
                .map(item -> item.getPrice())
                .reduce(0, (a, b) -> a + b);

        sum = items.stream()
                .map(x -> x.getPrice())
                .collect(Collectors.summingInt(Integer::intValue));

        sum = items.stream()
                .mapToInt(x -> x.getPrice())
                .sum();
    }
}

class ArithmeticUtils {

    public static int add(int a, int b) {
        return a + b;
    }
}

class Item {

    private int id;
    private Integer price;

    public Item(int id, Integer price) {
        this.id = id;
        this.price = price;
    }

    // Standard getters and setters

    public Integer getPrice() {
        return price;
    }
}
