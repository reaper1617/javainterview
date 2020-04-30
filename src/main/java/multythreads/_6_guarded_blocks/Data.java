package multythreads._6_guarded_blocks;


public class Data {
    private String message;
    private volatile boolean empty = true;

    public synchronized void put(String message){
        while (!empty){
            try {
                System.out.println("[Data::put] Data not empty! Waiting ... ");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("[Data::put] Data empty! Put new data: " + message);
        this.message = message;
        empty = false;
        notifyAll();
    }

    public synchronized String get(){
        while (empty){
            try{
                System.out.println("[Data::get] Data is empty! Waiting ... ");
                wait();
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println("[Data::get] Data is not empty! Fetching message: " + this.message);
        empty = true;
        String msg = this.message;
        notifyAll();
        return msg;
    }
}
