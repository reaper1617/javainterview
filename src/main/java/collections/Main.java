package collections;

import java.util.*;

public class Main {
    public static void main(String[] args) {


        Set<Integer> integers = new LinkedHashSet<>();
        new HashSet<Integer>().add(null);
        List<Integer> integerList = new ArrayList<>();
        Map<String, Integer> map = new TreeMap<>();
        Collections.synchronizedMap(map);

    }
}
