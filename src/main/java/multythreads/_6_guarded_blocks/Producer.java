package multythreads._6_guarded_blocks;

public class Producer implements Runnable {
    private Data data;

    public Producer(Data data) {
        this.data = data;
    }

    @Override
    public void run() {
        for(int i = 0; i < 100; i++){
            System.out.println("[Producer::run] Producing new message with content: " + i);
            data.put("New message with content: " + i);
        }
        System.out.println("[Producer::run] Producing exit message ...");
        data.put("exit");
    }
}
