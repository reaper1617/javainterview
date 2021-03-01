package java_collections.sets;

import java.util.*;

public class SetsMain {
    public static void main(String[] args) {

        // HashSet
        Set<Integer> integersHashSet = new HashSet<>();


        // TreeSet
        Set<Integer> integersTreeSet = new TreeSet<>();
        Set<Integer> integersTreeSet2 = new TreeSet<>( (left, right) -> left.compareTo(right));
        Set<Integer> integersTreeSet3 = new TreeSet<>(integersTreeSet2);
        List<Integer> integerList = List.of(1,2,2,3,3);
        Set<Integer> integersTreeSet4 = new TreeSet<>(integerList);


        // SortedSet

        // NavigableSet

        //

    }
}
