package sri.examples.streams;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsInterMediateOperationsMain {
    public static void main(String[] args) {
        IntStream.iterate((int)'A',i->i<=(int)'z',i->i+1)
                .forEach(e-> System.out.printf("%c ",e));

        System.out.println("\n______________________________________________");
        IntStream.iterate((int)'A',i->i<=(int)'z',i->i+1)
                .filter(Character::isAlphabetic)
                .forEach(e-> System.out.printf("%c ",e));

        System.out.println("\n______________________________________________");
        IntStream.iterate((int)'A',i->i<=(int)'z',i->i+1)
                .filter(Character::isAlphabetic)
                .filter(i->Character.toUpperCase(i)>'E')
                .forEach(e-> System.out.printf("%c ",e));
        //another method on the Character wrapper class, to upper case, that takes an integer, and compare that to the character, a literal E. If the value is greater than E, it will be part of the output stream.
        //There's really no limit to the number of intermediate operations you specify, and you can use one operation many times, and in any order you want.
        //Again, these operations are a specification to the stream processor. The processor may decide it's more efficient to join those two conditions together, in the black box of the stream process. This is why we have to stop thinking of these operations as methods, because in some cases, they'll never be used in the way we define them, but will be optimized by the stream processing code.
        //Running this code now,
        System.out.println("\n______________________________________________");
        //If I only wanted to skip the capital letters, a, through e, I could use the skip method.
        //when you'll want to skip elements in a stream.

        IntStream.iterate((int)'A',i->i<=(int)'z',i->i+1)
                .filter(Character::isAlphabetic)
                .skip(5)
                .forEach(e-> System.out.printf("%c ",e));

        System.out.println("\n______________________________________________");
        //next include a dropWhile statement that will do the same thing.
        IntStream.iterate((int)'A',i->i<=(int)'z',i->i+1)
                .filter(Character::isAlphabetic)
                .dropWhile(i->i<='E')
                .forEach(e->System.out.printf("%c ",e));
        //dropWhile operation takes a predicate and will filter out any elements while they match this condition.Unlike filter, this predicate is only evaluated for elements, until it first becomes false.
        System.out.println("\n______________________________________________");
        IntStream.iterate((int)'A',i->i<(int)'z',i->i+1)
                .filter(Character::isAlphabetic)
                .dropWhile(i->i<='E')
                .takeWhile(i->i<'a')
                .forEach(e->System.out.printf("%c ",e));

        //The dropWhile and takeWhile work well with ordered streams.
        //If the stream isn't ordered, oracle tells us the result will be non-deterministic, meaning the results may differ upon subsequent executions
        System.out.println("\n______________________________________________");
        //----Distinct operation
        IntStream.iterate((int)'A',i->i<'z',i->i+1)
                .filter(Character::isAlphabetic)
                .map(Character::toUpperCase)
                .distinct()
                .forEach(e->System.out.printf("%c ",e));
        //Again, this is probably not the most logical piece of code, but it does demonstrate how distinct works.

        System.out.println("\n______________________________________________");


        //The Java API designers designed the Stream to let you process data in a declarative way, much like a structured query language or SQL in a database. Again this lets you say what should happen, and not actually how it will happen.
        //If you've had experience querying databases, you might be familiar with the limit and distinct keywords, available in some database query languages.
        //The filter operation represents your where clause, and sorted would be your order by clause, and so on. When we get to terminal operations, you'll see There are aggregate functions commonly used in queries as well, such as max, min, count and so on.

        //======================map, peek, sorted ================================

        //The map function is both simple and powerful. It can turn one stream into another kind, and since we can use as many map operations as we want, we could do a lot with this one operation. It can be as complex or simple as you want it to be as well.
        //The peek method is aptly named because it's commonly used to print elements in interim operations, so you can get an understanding of what is really happening Of course, you're not limited to just printing output.
        //This operation is susceptible to intentional, or unintentional, side effects.
        //Finally, there's the sorted operation. We've covered sorted a lot with collections, and this operation is similarly structured to the sort method on implemented collections. You can use it without specifying an argument, for elements that implement the Comparable interface. If you want a different kind of sort, or the elements in your stream don't implement Comparable, you'd pass a Comparator.
        //The sorted method gets complicated when you use parallel streams, but I'll cover those complexities in the concurrency section of the course.


        //======================//
        //I want to examine the map operation in a little more detail.
        //I'm going to create a Seat record for the examples I'll be using in this.

        System.out.println("\n______________________________________________");
        int maxSeats=100;
        int seatsInRow=10;
        Stream<Seat> seatStream = Stream.iterate(0, i -> i < maxSeats, i -> i + 1)
                .map(i -> new Seat((char) ('A' + i / seatsInRow),
                        i % seatsInRow + 1));
        seatStream.forEach(System.out::println);

    }
}
