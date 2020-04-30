package multythreads._2_interrupting;

public class InterruptMain {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("Start of main");

        Thread t1 = new Thread(() -> {
            try {
                for (int i = 0; i < 50000000; i++) {

                    System.out.println("Thread t1, i = " + i);
                    //instead of Thread.sleep();
                    for (int j = 0; j < 50000000; j++) {
                        double d = j * j;
                    }
                    // because of long-time operation we need to check periodically of our thread received a signal to interrupt
                    if (Thread.interrupted()) {
                        System.out.println("Check for t1: interrupted!");
                        // throw ex instead of return for putting all the code for interrupting handling in one place
                        throw new InterruptedException("t1 has been interrupted!");
//                   return;
                    } else {
                        System.out.println("Check for t1: NOT interrupted!");
                    }

//                    Thread.sleep(1000);

                }
            } catch (InterruptedException e) {
                System.out.println("t1 interrupted ! " + e.getMessage());
                // important !!! if no return then after interruption thread will continue to work
//                return;
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                for (int i = 0; i < 50000000; i++) {
                    System.out.println("Thread t2, i = " + i);
                    for (int j = 0; j < 50000000; j++) {
                        double d = j * j;
                    }
                    if (Thread.interrupted()) {
                        System.out.println("Check for t2: interrupted!");
                        throw new InterruptedException("t1 has been interrupted!");
//                        return;
                    } else {
                        System.out.println("Check for t2: NOT interrupted!");
                    }
//                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                System.out.println("t2 interrupted ! " + e.getMessage());
                // important !!! if no return then after interruption thread will continue to work
//                    return;
            }
        });

        t1.start();
        t2.start();
        System.out.println("Main sleeps 5 sec ...");
        Thread.sleep(5000);
        System.out.println("Main wakes up");
        // check if interrupted (flag of interruption does not set at 0)
        System.out.println("check if t1 is interrupted: " + t1.isInterrupted());

        System.out.println("Interrupting t1 ...");
        // behaviour depends on how thread runnable task implements logic of thread interrupting
        t1.interrupt();

        System.out.println("Interrupting t2 ...");
        t2.interrupt();


        // check if interrupted (flag of interruption does not set at 0)
        System.out.println("Main: " + Thread.interrupted());

        System.out.println("End of main");

    }
}
