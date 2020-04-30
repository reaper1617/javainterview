package multythreads._6_guarded_blocks;

public class GuardedBlocksMain {
    public static void main(String[] args) {
        Data sharedData = new Data();
        Thread consumerThread = new Thread(new Consumer(sharedData));
        Thread producerThread = new Thread(new Producer(sharedData));
        producerThread.start();
        consumerThread.start();
    }
}
