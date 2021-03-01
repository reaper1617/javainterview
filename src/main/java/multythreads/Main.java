package multythreads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;

public class Main {


    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {

            try {
                System.out.println("[t1]: started");
                Thread.sleep(2000);
                System.out.println("[t1]: in the middle");
                Thread.sleep(2000);
                System.out.println("[t1]: finishing");
            } catch (InterruptedException e) {
                System.out.println("[t1]: was interrupted: " + e);
            }
        });


        Thread t2 = new Thread(() -> {
            try {
                System.out.println("[t2]: started");
                Thread.sleep(2000);
                System.out.println("[t2]: in the middle");
                Thread.sleep(2000);
                System.out.println("[t2]: finishing");
            } catch (InterruptedException e) {
                System.out.println("[t2]: was interrupted: " + e);
            }
        });


        System.out.println("Starting threads ...");
        t1.start();
        t2.start();
        System.out.println("Finished main.");
        // exception!  java.lang.IllegalThreadStateException
        // because thread can not be started again after finishing
//        t1.start();


        Callable<Integer> callable = () -> {
            System.out.println("Callable called!");
            return 1;
        };
        int res = 0;
//        try {
//            res = callable.call();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        System.out.println("Callable res: " + res);


        FutureTask<Integer> futureTask = new FutureTask<>(callable);
        futureTask.run();
        try {
            Integer futureRes = futureTask.get();
            System.out.println("Future res: " + futureRes);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


        Executor executor = Runnable::run;
        executor.execute( ()-> {
            System.out.println("Executor is working!");
        });

    }

}
