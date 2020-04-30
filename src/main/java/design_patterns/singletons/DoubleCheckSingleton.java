package design_patterns.singletons;

public class DoubleCheckSingleton {
    private static DoubleCheckSingleton instance;


    private DoubleCheckSingleton() {

    }

    public DoubleCheckSingleton getInstance() {
        if (instance == null) {
            synchronized (DoubleCheckSingleton.class) {
                if (instance == null) instance = new DoubleCheckSingleton();
            }
        }
        return instance;
    }
}
