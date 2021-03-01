package multythreads._11_exceptions_catching;

public class ExceptionCatchingMain {
    public static void main(String[] args) {
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = getThreadUncaughtExHandler();
        Thread anotherThread = getAnotherThread();

        anotherThread.setUncaughtExceptionHandler(uncaughtExceptionHandler);

        anotherThread.start();
    }

    private static Thread getAnotherThread(){
        return new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Throwing exception...");
            throw new RuntimeException("Example");
        });
    }

    private static Thread.UncaughtExceptionHandler getThreadUncaughtExHandler(){
        return (t, e) -> System.out.println("Caught " + e.getMessage() + " in thread " + t.getName());
    }
}
