package generics;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        CustomContainer<Integer> customContainer = new CustomContainer<>(new Integer[]{1,2,3});

        customContainer.printData();



        // with wildcards

        List<?> unbound = new ArrayList<>();
        // unbound.add(1); // compile error! <?> are immutable!

        List<?> unbound2 = Arrays.asList(1,2,3);  // ok

        // compile error!
//        List<Number> numbers = new ArrayList<Integer>();
        List<Number> numbers1 = new ArrayList<Number>(); // ok
        List<? extends Number> numbers2 = new ArrayList<>(); // ok
        List<? extends Number> numbers3 = new ArrayList<Integer>(); // ok


//        numbers2.add(new Integer(4)); // compile error! <? extends Smth> is immutable, we can use it as methods args

        // pass list of integer nums
        List<Integer> integerList = Arrays.asList(1,2,3,4);
        showWildcardUseAsMethodParam(integerList);

        // now pass list of short nums
        List<Short> shortList = Arrays.asList((short) 1, (short)2);
        showWildcardUseAsMethodParam(shortList);


        List<? super IOException> exceptions = new ArrayList<Exception>();
        //exceptions.add(new Exception()); // compile error!
        exceptions.add(new IOException()); // ok


    }


    private static void showWildcardUseAsMethodParam(List<? extends Number> list){
        list.forEach(
                el -> {
                    System.out.println("Element: " + el + ", type: " + el.getClass().getName());
                }
        );
    }
}
