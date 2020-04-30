package design_patterns.singletons;

import java.util.concurrent.Callable;

public enum EnumSingleton {
    INSTANCE;

    int val;

    public void setValue(int val) {
        this.val = val;
    }
}
