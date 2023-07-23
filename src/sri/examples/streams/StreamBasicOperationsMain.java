package sri.examples.streams;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamBasicOperationsMain {
    public static void main(String[] args) {
        List<String> bingoPool=new ArrayList<>(75);
        int start=1;
        for(char c: "BINGO".toCharArray()){
            for(int i=start;i<(15+start);i++){
                bingoPool.add(""+c+i);
                //System.out.println(""+c+i);
            }
            start+=15;
        }
        Collections.shuffle(bingoPool);
        for(int i=0;i<15;i++){
            System.out.println(bingoPool.get(i));
        }
        System.out.println("______________________________________________");
        //List<String> firstOnes= bingoPool.subList(0,15);
        List<String> firstOnes= new ArrayList<>(bingoPool.subList(0,15));
        firstOnes.sort(Comparator.naturalOrder());

        firstOnes.replaceAll(s->{
            if(s.indexOf("G")==0 || s.indexOf("O")==0){
                String updated=s.charAt(0)+"-"+s.substring(1);
                System.out.print(updated+" ");
                return updated;
            }
            return s;
        });
        System.out.println("\n______________________________________________");

        // performing the same above operations using streams.
        bingoPool.stream()
                .limit(15)
                .filter(s->(s.indexOf("G")==0)||s.indexOf("O")==0)
                .map(s->s.charAt(0)+"-"+s.substring(1))
                .sorted()
                .forEach(s-> System.out.print(s+" "));
        System.out.println("\n______________________________________________");
        for(int i=0;i<15;i++){
            System.out.println(bingoPool.get(i));
        }
        System.out.println("\n______________________________________________");
        String[] strings={"One","Two","Three"};
        var firstStream=Arrays.stream(strings)
                .sorted(Comparator.reverseOrder());
                //.forEach(System.out::println);

        var secondStream=Stream.of("Six","Five","Four")
                .map(String::toUpperCase);
                //.forEach(System.out::println);
        Stream.concat(secondStream,firstStream)
                .map(s->s.charAt(0)+" - "+s)
                .forEach(System.out::println);

        Map<Character,int[]>myMap=new LinkedHashMap<>();
        int bingoIndex=1;
        for(char c:"BINGO".toCharArray()){
            int[]numbers=new int[15];
            int lableNo=bingoIndex;
            Arrays.setAll(numbers,i->i+lableNo);
            myMap.put(c,numbers);
            bingoIndex+=15;
        }

        myMap.entrySet()
                .stream()
                .map(e->e.getKey()+" has range: "+e.getValue()[0]+" - "
                +e.getValue()[e.getValue().length-1])
                .forEach(System.out::println);
        //Infinite streams.
        Random random=new Random();
        Stream.generate(()->random.nextInt(2)) // This will generate a series of 0's and 1's infinitely.
                .limit(10)
                .forEach(s->System.out.print(s+ " "));

        System.out.println("\n______________________________________________");
        IntStream.iterate(1,n->n+1) //iterate, which gives us the option of generating either a finite or infinite stream., this is infinite case and we are liminting it using limit operation.
                .limit(20)
                .forEach(s->System.out.print(s+" "));
        //This code works if I use IntStream or Stream. If I had used Stream though, Java would have been autoboxing and unboxing integers, on each method call, which makes it less efficient, especially with large amounts of data.
        System.out.println("\n______________________________________________");

        IntStream.iterate(1,n->n+1)
                .filter(StreamBasicOperationsMain::isPrime)
                .limit(20)
                .forEach(s->System.out.print(s+" "));
        System.out.println("\n______________________________________________");
        IntStream.iterate(1,n->n+1)
                .limit(100)
                .filter(StreamBasicOperationsMain::isPrime)
                .forEach(s->System.out.print(s+" "));

        //Consider the differences between these two pipelines for a minute. In the first case, numbers can be fed indefinitely into the streaming process, until enough numbers match the condition first, and then match the limiting size.
        //In the second case though, I'm saying that I only want to check a specified number of elements, and will operate on that specific size.Because streams are lazy, the stream process isn't going to generate an infinite number of possibilities first and then process the other operations.
        //In other words, it's not going to hang on the stream creation. The evaluation stage I talked about earlier, that optimizes stream operations, will manage how many elements are actually created in the stream, to provide the desired result.
        //However, let me add a word of caution. If you don't provide a limiting factor, you can still produce an out of memory condition.
        System.out.println("\n______________________________________________");
        //The iterate method has an overloaded version, which provides a finite stream, because it's conditional.
        IntStream.iterate(1,n->n<20,n->n+1)
                .filter(StreamBasicOperationsMain::isPrime)
                .forEach(s->System.out.print(s+" "));
        //The overloaded iterate method, has three parameters, the first is still the seed, but the second parameter, the additional parameter, is a predicate functional interface type. The third parameter is the UnaryOperator.
        //The first uses an infinite stream, limited by an intermediate operation.
        //The second uses a finite stream, it's limiting condition declared as the second parameter.
        System.out.println("\n______________________________________________");

        //There're two additional methods, which I can use on any of the primitive streams,so on IntStream like I have here, or with DoubleStream or LongStream.These are range and rangeClosed.
        IntStream.range(1,100) //range, which takes a starting and ending value, and automatically increments by one.
                .filter(StreamBasicOperationsMain::isPrime)
                .forEach(s->System.out.print(s+" "));

        System.out.println();
        IntStream.rangeClosed(1,100)
                .filter(StreamBasicOperationsMain::isPrime)
                .forEach(s->System.out.print(s+" "));

        System.out.println();
       


    }

    private static boolean isPrime(int number){
        if(number<=2){
            return (number == 2);
        }

        for(int divisor=2;divisor<=number / 2;divisor++){
            if(number%divisor == 0){
                return Boolean.FALSE;
            }
        }
        return Boolean.TRUE;

    }
}
