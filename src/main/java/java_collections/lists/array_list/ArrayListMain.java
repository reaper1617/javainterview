package java_collections.lists.array_list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ArrayListMain {
    public static void main(String[] args) {

        // create
        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(1);
        integerList.add(1);

        List<Integer> integerList2 = new ArrayList<>(10); // initial capacity = 10
        List<Integer> integerList3 = new ArrayList<>(integerList);

        System.out.println("List 1:" + integerList);
        System.out.println("List 2:" + integerList2);
        System.out.println("List 3:" + integerList3);

        List<String> stringList = List.of("1", "2", "3", "4", "5");
        List<Character> characterList = Stream.of('a', 'b', 'c').collect(Collectors.toList());

        List<Character> characterList2 = Arrays.asList('1', '2', '3');
        // add
        integerList.add(2);
        integerList.add(3);

        integerList.addAll(integerList3);

        integerList.add(1, 2); // insert elem '2' into position with index '1'
        System.out.println("List: " + integerList);

        // get
        Integer elem0 = integerList.get(0);
        System.out.println("Element 0: " + elem0);

        // ensure capacity
        ((ArrayList) integerList).ensureCapacity(10); // increase capacity
        ((ArrayList) integerList).trimToSize(); // copy data to new array with specified size

        //index of element
        int indexOf2 = integerList.indexOf(2);
        System.out.println("Index of 2: " + indexOf2);

        int indexOf55 = integerList.indexOf(55);
        System.out.println("Index of 55: " + indexOf55); // -1 because not found

        //contains
        boolean contains1 = integerList.contains(1);
        System.out.println("Contains 1: " + contains1);

        // remove
        Integer removedObj = integerList.remove(0); // remove BY INDEX because 'little' int
        System.out.println("Removed obj: " + removedObj);
        boolean removed = integerList.remove(Integer.valueOf(1)); // remove OBJECT '1'
        System.out.println("Removed: " + removed);

        boolean removedByPredicate = integerList.removeIf(el -> el > 2); // remove by predicate
        System.out.println("Removed by predicate: " + removedByPredicate);

        // set
        Integer set = integerList.set(0, 22); // replace value of element with index 0 to value 22
        System.out.println("Set: " + set); // return 2 (previous value)

        // clear
        List<Integer> copied = new ArrayList<>(integerList);
        integerList.clear(); // fills all the elements of array to 'null'... faster than 'removeAll(Collection c)'
        System.out.println("Cleared: " + integerList);

        // removeAll
        copied.removeAll(integerList);

        // toArray
        Object[] arr = copied.toArray(); // to array of Object
        System.out.println("Object[]: " + Arrays.toString(arr));
        Integer[] arr2 = copied.toArray(new Integer[copied.size()]); // to specified array of type
        System.out.println("Arr2: " + Arrays.toString(arr2));



    }
}
