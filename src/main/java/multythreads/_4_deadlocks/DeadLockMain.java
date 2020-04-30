package multythreads._4_deadlocks;

public class DeadLockMain {


    static class ExampleClass {

        public synchronized void method1(ExampleClass exampleClass) {
            System.out.println(exampleClass + " In method 1, thread " + Thread.currentThread().getName());
            method2(this);
        }

        public synchronized void method2(ExampleClass exampleClass) {
            System.out.println(exampleClass + " In method 2, thread " + Thread.currentThread().getName());
        }


    }

    public static void main(String[] args) {
        final ExampleClass ex1 = new ExampleClass();
        final ExampleClass ex2 = new ExampleClass();

        new Thread(() -> {
            ex1.method1(ex2);
        }).start();

        new Thread(() -> {
            ex2.method1(ex1);
        });

        // result: deadlock because:
        // 1. thread 1 acquires monitor of ex1
        // 2. thread 2 acquires monitor of ex2
        // 3. thread 1 tries to acquire monitor of ex2 (when invoking method2(this), this == ex2)
        // 4. thread 2 tries to acquire monitor of ex1 (when invoking method2(this), this == ex1)
        // 3 and 4 failed because both monitors has been already acquired by another thread
        //log message
        // multythreads._4_deadlocks.DeadLockMain$ExampleClass@72e12e59 In method 1, thread Thread-0
        // multythreads._4_deadlocks.DeadLockMain$ExampleClass@b8473ed In method 2, thread Thread-0


        // see the example of solution in package  multythreads._7_reentrantlocks

    }
}
