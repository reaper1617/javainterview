package java_collections.java_iterators.fail_fast_or_fail_safe_iterators;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        // fail-fast: operates with collection directly
        // if collection has been modified => ConcurrentModificationException

        List<Integer> integerList = List.of(1,2,3,4,5,6,7,8,9,10);
        List<Integer> integerList2 = new ArrayList<>(integerList); // to make it mutable
        Iterator<Integer> it = integerList2.iterator();

        Thread t2 = new Thread(() -> {
            try {
                Thread.sleep(new Random().nextInt(2000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Removing element 9");
            integerList2.remove(9);
        });
        t2.start();

        // expecting exception java.util.ConcurrentModificationException
        // because of modifying collection while iterating it

        while (it.hasNext()){
            System.out.println("Getting next: " + it.next());
            System.out.println("Sleeping 2000");
            Thread.sleep(2000);
            System.out.println("Waking up");
        }




        // fail-safe: operates with copy of collection
        // no exception
    }
}
