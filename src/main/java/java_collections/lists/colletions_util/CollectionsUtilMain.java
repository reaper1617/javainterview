package java_collections.lists.colletions_util;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class CollectionsUtilMain {
    public static void main(String[] args) {


        List<String> stringList = List.of("Murzik", "Barsik", "Vaska");

        // frequency
        int count = Collections.frequency(stringList, "Murzik");

        System.out.println("Murzik freq: " + count);

    }
}
