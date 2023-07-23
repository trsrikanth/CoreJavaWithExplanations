package sri.examples.streams.bingo_challenge;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BingoChallenge {
    public static void main(String[] args) {
        Random random =new Random();
        Stream<String> streamB = Stream.generate(() -> random.nextInt(1,16))
                .distinct()
                .limit(15)
                .sorted()
                .map(e -> "B" + e);

        Stream<String> streamI = Stream.of(16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30)
                .map(e -> "I" + e);
        Stream<String> streamN = IntStream.rangeClosed(31, 45)
                .mapToObj(e -> "N" + e);
        int seed=46;
        Stream<String> streamG = Stream.iterate(seed, i -> i <= 60, i -> i + 1)
                .map(e -> "G" + e);

        String[] oLables=new String[15];
        Arrays.setAll(oLables,i->"O"+(61+i));
        Stream<String> streamO = Arrays.stream(oLables);

        Stream<String> streamBI = Stream.concat(streamB, streamI);
        Stream<String> streamNG = Stream.concat(streamN, streamG);
        Stream<String> streamBING = Stream.concat(streamBI, streamNG);
        Stream<String> streamBINGO = Stream.concat(streamBING, streamO);
        streamBINGO.forEach(System.out::println);

        //streamO.forEach(System.out::println);

    }
}
