package java8updates.func_interfaces_and_method_refs;

@FunctionalInterface
public interface CustomFunctionalInterface<F,T> {
    T apply(F from);
}
