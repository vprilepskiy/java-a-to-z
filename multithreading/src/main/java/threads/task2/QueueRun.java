package threads.task2;


/**
 * Created by VLADIMIR on 20.09.2017.
 */
public class QueueRun {

    /**
     * Terminator.
     */
    static class Terminator implements Runnable {

        /**
         * Thread for interrupt.
         */
        private final Thread thread;

        /**
         * Constructor.
         *
         * @param thread - Thread for interrupt.
         */
        Terminator(Thread thread) {
            this.thread = thread;
        }

        /**
         * Run.
         */
        @Override
        public void run() {
            if (this.thread != null && this.thread.isAlive()) {
                System.out.printf("%s %s \n", "Terminate: ", this.thread.getName());
                this.thread.interrupt();
            }
        }
    }

    /**
     * Processing.
     */
    static class Processing extends Thread {
        /**
         * Constructor.
         * @param name - Thread name.
         */
        Processing(String name) {
            super(name);
        }

        /**
         * Run.
         */
        public void run() {
            System.out.printf("%s %s \n", "Run:", this.getName());
            while (true) {
                if (this.isInterrupted()) {
                    break;
                }
            }
        }
    }
}

/**
 * Main class.
 */
class MainClass {

    /**
     * Wait before terminate.
     */
    private static final long WATCH_DOG_TIMER = 1000;

    /**
     * Main method.
     *
     * @param args - args.
     */
    public static void main(String[] args) {

        Thread processing = new QueueRun.Processing("PROCESSING");
        Thread terminator = new Thread(new QueueRun.Terminator(processing));

        System.out.println("Start");

        try {
            processing.start();
            processing.join(WATCH_DOG_TIMER);

            terminator.start();
            terminator.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("End");
    }

}
