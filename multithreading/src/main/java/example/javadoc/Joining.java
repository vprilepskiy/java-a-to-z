package example.javadoc;

/**
 * Created by VLADIMIR on 20.09.2017.
 */
public class Joining {

    /**
     * Thread.
     */
    static class MyThread implements Runnable {
        /**
         * Message.
         */
        private final String message;
        /**
         * Number of run.
         */
        private final int number;
        /**
         * Pause between run.
         */
        private final int millis;

        /**
         * Constructor.
         * @param message - name.
         * @param number - number of run.
         * @param millis - pause between run.
         */
        MyThread(String message, int number, int millis) {
            this.message = message;
            this.number = number;
            this.millis = millis;
        }

        /**
         * Body run method.
         */
        @Override
        public void run() {
            final long start = System.currentTimeMillis();
            for (int i = 0; i < this.number; i++) {
                System.out.println(this.message + "; time: " + (System.currentTimeMillis() - start) + "ms.");
                try {
                    Thread.sleep(this.millis);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}

/**
 * Main Class.
 */
class MainClass {

    /**
     * Main method.
     * @param args - args.
     * @throws InterruptedException - exception.
     */
    public static void main(String[] args) throws InterruptedException {

        final Thread t0 = new Thread(new Joining.MyThread("Thread-0", 15, 1000));
        final Thread t1 = new Thread(new Joining.MyThread(" Thread-1", 15, 1000));

        System.out.println("start");

        t0.start();
        final int millis = 5000;
        t0.join(millis);
        t1.start();
        t1.join();

        System.out.println("end");
    }

}