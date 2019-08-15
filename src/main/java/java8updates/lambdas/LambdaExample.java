package java8updates.lambdas;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LambdaExample {

    public static void main(String[] args) {

        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
        Collections.sort(names, (String a, String b) -> {return a.compareTo(b);} );

        Collections.sort(names, (a,b) -> a.compareTo(b));

        Collections.sort(names, String::compareTo); // refs!

    }

}
