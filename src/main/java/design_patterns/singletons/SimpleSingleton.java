package design_patterns.singletons;

public class SimpleSingleton {


    private static final SimpleSingleton instance = new SimpleSingleton();

    private SimpleSingleton(){

    }

    public static SimpleSingleton getInstance() {
        return instance;
    }
}
