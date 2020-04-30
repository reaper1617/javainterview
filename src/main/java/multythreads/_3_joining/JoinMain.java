package multythreads._3_joining;

public class JoinMain {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread( () -> {
            try {
                for (int i = 0; i < 15; i++) {
                    System.out.println("Thread t, iteration " + i);
                    Thread.sleep(1000);
                }
            }
            catch (InterruptedException e){
                System.out.println("Thread T Interrupted!");
            }
        });

        System.out.println("Starting thread t ...");
        t.start();

        System.out.println("Main sleeps ...");
        Thread.sleep(3000);
        System.out.println("Main wakes up");


        System.out.println("Joining t to main");

        // without join : concurrent execution
        // with join - main thread waits for t thread to be executed fully
        t.join();

        for(int i = 0; i < 10; i++){
            System.out.println("Main thread, iteration: " + i);
            Thread.sleep(1000);
        }

        System.out.println("End of main");
    }

}
