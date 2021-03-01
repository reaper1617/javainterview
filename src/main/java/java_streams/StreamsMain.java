package java_streams;

import java.util.stream.Stream;

public class StreamsMain {

    public static void main(String[] args) {


        // methods


        // allMatch
        boolean res = Stream.of(1,2,3).allMatch(el -> el > 2);

    }
}
