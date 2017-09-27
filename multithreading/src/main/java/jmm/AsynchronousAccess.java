package jmm;

/**
 * Created by VLADIMIR on 26.09.2017.
 */
public class AsynchronousAccess {

    /**
     * Number.
     */
    private int x = 0;

    /**
     * Start two thread.
     * @return - result.
     */
    public int count() {

        Thread thread1 = new Thread(new Counter());
        Thread thread2 = new Thread(new Counter());

        thread1.start();
        thread2.start();

        // wait when finished all threads.
        while (thread1.isAlive() || thread2.isAlive()) {
            final int sleepMillis = 100;

            try {
                Thread.sleep(sleepMillis);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return this.x;
    }


    /**
     * Increment number.
     */
    class Counter implements Runnable {

        /**
         * Number of iterations for increment operations.
         */
        private final int numberOfIterations = 500_000_000;

        @Override
        public void run() {
            for (int i = 0; i < this.numberOfIterations; i++) {
                x++;
            }
        }
    }
}
