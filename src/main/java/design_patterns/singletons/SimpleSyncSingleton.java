package design_patterns.singletons;

public class SimpleSyncSingleton {

    private static volatile SimpleSyncSingleton instance;

    private SimpleSyncSingleton() {

    }

    private static synchronized SimpleSyncSingleton getInstance() {

        if (instance == null) instance = new SimpleSyncSingleton();
        return instance;
    }

}
