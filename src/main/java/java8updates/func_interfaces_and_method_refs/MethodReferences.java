package java8updates.func_interfaces_and_method_refs;

import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class MethodReferences {

    public static void main(String[] args) {
        CustomFunctionalInterface<Integer, String> customFunctionalInterface = (from ) -> Integer.toString(from);

        CustomFunctionalInterface<Double, String> customFunctionalInterface2 = (from ) -> Double.toString(from);

        CustomFunctionalInterface<Float, Float> customFunctionalInterface3 = Float::valueOf;


        String applied1 = customFunctionalInterface.apply(10);
        String applied2 = customFunctionalInterface2.apply(2.2);

        Float applied3 = customFunctionalInterface3.apply(3.3f);

        System.out.println(applied1);
        System.out.println(applied2);
        System.out.println(applied3);


        // predicate
        Predicate<String> predicate = (s) -> s.length()>10;
        System.out.println(predicate.test("sgsg"));
        System.out.println(predicate.negate().test("sfgsfg"));

        // functions
        Function<String, Integer> function = (s) -> s.length();
        Function<Integer,String> function2 = (i) -> i.toString();

        Function<String,String> function3 = function.andThen(String::valueOf);

        System.out.println(function.apply("sdgsdg"));
        System.out.println(function2.apply(10));
        System.out.println(function3.apply("sdgds"));

        // suppliers - no arguments
        Supplier<String> stringSupplier = String::new;

        System.out.println(stringSupplier.get());

        // consumers - operate on incoming argument
        Consumer<String> stringConsumer = (s) -> System.out.println(s+"_consumer");
        stringConsumer.accept("dfdfdf");

        //comparators
        Comparator<String> comparator = (s1,s2) -> s1.compareTo(s2);
        System.out.println(comparator.compare("sdgfd", "sdgsdg"));
        System.out.println(comparator.reversed().compare("sdgfd", "sdgsdg"));


    }
}
