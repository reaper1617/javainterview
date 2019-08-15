package java8updates.defaults_methods;

public interface InterfaceWithDefaults {
    String returnString();

    default double sqrt(double a){
        return a*a;
    }
}
