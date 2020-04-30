package multythreads._7_reentrantlocks;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLocksMain {

    static class ExampleClass {

        private String name;
        private final Lock lock = new ReentrantLock();

        public ExampleClass(String name) {
            this.name = name;
        }

        // tries to acquire both locks for this and given object exampleClass
        // and if failed to acquire both then unlock all
        public boolean prepareLocks(ExampleClass exampleClass) {
            boolean thisLock = false;
            boolean exampleClassLock = false;
            try {
                thisLock = lock.tryLock();
                exampleClassLock = exampleClass.lock.tryLock();
            } finally {
                if (!(thisLock && exampleClassLock)) {
                    if (thisLock) {
                        lock.unlock();
                    }
                    if (exampleClassLock) {
                        exampleClass.lock.unlock();
                    }
                }
            }
            return thisLock && exampleClassLock;
        }


        // util class for loop through methods executing
        static class Loop implements Runnable {

            private ExampleClass exampleClass1;
            private ExampleClass exampleClass2;

            public Loop(ExampleClass exampleClass1, ExampleClass exampleClass2) {
                this.exampleClass1 = exampleClass1;
                this.exampleClass2 = exampleClass2;
            }

            @Override
            public void run() {
                Random random = new Random();

                for (; ; ) {
                    try {
                        Thread.sleep(random.nextInt(5000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    exampleClass1.method1(exampleClass2);
                }
            }
        }

        public void method1(ExampleClass exampleClass) {
            if (prepareLocks(exampleClass)) {
                try {
                    System.out.println("[ExampleClass::method1, object: " + name + "]" + " Method 1 invoked");
                    method2(this);
                } finally {
                    this.lock.unlock();
                    exampleClass.lock.unlock();
                }
            } else {
                System.out.println("[ExampleClass::method1], object: " + name + "]" + " lock for both already acquired by another");
            }
        }

        public void method2(ExampleClass exampleClass) {
            System.out.println("[ExampleClass::method2] Method 2 invoked");
        }

        public static void main(String[] args) {
            ExampleClass e1 = new ExampleClass("Ex1");
            ExampleClass e2 = new ExampleClass("Ex2");
            new Thread(new Loop(e1, e2)).start();
            new Thread(new Loop(e2, e1)).start();
        }

    }
}
