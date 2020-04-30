package multythreads._1_creating_threads;

public class Main {

    public static void main(String[] args) {
        CustomThread t1 = new CustomThread();
        CustomThread2 t2 = new CustomThread2();
        // run one after another (no concurrency)
        t1.run();
        t2.run();

        System.out.println("Trying to start concurrent mode");
        // concurrent because of invokation 'start' method
        t1.start();
        t2.start();
    }
}
