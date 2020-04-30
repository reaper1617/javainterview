package collections.lists;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        // ArrayList

        List<String> list = new ArrayList<>();
        List<String> list2 = new ArrayList<>(10); // initial capacity
        List<String> list3 = new ArrayList<>(list); // copying collection

        String[] strsArr = {"s1", "s2"};
        List<String> list4 = Arrays.asList(strsArr);

        list.add("str1");
        list.add(0, "str2");
        String s1 = list.get(0);
        System.out.println(s1);
        list.remove("str2");
        System.out.println(list.get(0));
        list.set(0, "set");
        System.out.println(list.get(0));

        //sort
        int[] numbers = {6, 9, 1, 8};
        Arrays.sort(numbers);
        System.out.println(Arrays.binarySearch(numbers, 6));
        System.out.println(Arrays.binarySearch(numbers, 3));

        List<Integer> integerList = Arrays.asList(9,7,5,3);
        Collections.sort(integerList);
        System.out.println(Collections.binarySearch(integerList, 3));
        System.out.println(Collections.binarySearch(integerList, 2));

        // boxing/ unboxing
        List<Integer> iNumbers = new ArrayList<>();
        iNumbers.add(1);
        iNumbers.add(new Integer(3));
        iNumbers.add(new Integer(5));
        iNumbers.remove(1);
        iNumbers.remove(new Integer(5));
        System.out.println(iNumbers);

    }
}
