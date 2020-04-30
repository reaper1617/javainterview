package multythreads._1_creating_threads;

public class CustomThread2 extends Thread {
    @Override
    public void run() {
        int i = 0;
        while (i < 10){
            i++;
            System.out.println("Thread 2 writing to console");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
