package example.javadoc;

/**
 * Created by VLADIMIR on 19.09.2017.
 */
public class Starting {

    /**
     * Provide a Runnable object. The Runnable interface defines a single method, run, meant to contain the code executed in the thread. The Runnable object is passed to the Thread constructor, as in the HelloRunnable example.
     */
    public static class HelloRunnable implements Runnable {
        /**
         * Run.
         */
        @Override
        public void run() {
            System.out.println("Hello from a thread!");
        }

        /**
         * Main Class.
         * @param args - args.
         */
        public static void main(String[] args) {
            (new Thread(new HelloRunnable())).start();
        }

    }



    /**
     * Subclass Thread. The Thread class itself implements Runnable, though its run method does nothing. An application can subclass Thread, providing its own implementation of run, as in the HelloThread example.
     */
    public static class HelloThread extends Thread {
        /**
         * Run.
         */
        public void run() {
            System.out.println("Hello from a thread!");
        }

        /**
         * Main Class.
         * @param args - args.
         */
        public static void main(String[] args) {
            (new HelloThread()).start();
        }

    }

}
