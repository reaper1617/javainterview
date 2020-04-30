package multythreads._6_guarded_blocks;

public class Consumer implements Runnable {

    private Data data;

    public Consumer(Data data) {
        this.data = data;
    }

    @Override
    public void run() {
        String currentMessage;
        while (!"exit".equalsIgnoreCase(currentMessage = data.get())){
            System.out.println("[Consumer::run] Trying to consume new message ...");
            System.out.println("[Consumer::run] Consumed message: " + currentMessage);
        }
    }
}
