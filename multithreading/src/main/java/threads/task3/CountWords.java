package threads.task3;

import threads.task1.Counter;

/**
 * Created by VLADIMIR on 21.09.2017.
 */
public class CountWords {

    /**
     * Wait before terminate.
     */
    private static final long WATCH_DOG_TIMER = 1000;

    /**
     * Count.
     */
    private final Thread count;
    /**
     * Time.
     */
    private final Thread time;

    /**
     * Constructor initialize two threads.
     *
     * @param line - words.
     */
    public CountWords(String line) {
        this.count = new Thread(new CountWords.CountChar(line));
        this.time = new Thread(new CountWords.Time());
    }


    /**
     * Start threads.
     */
    public void count() {
        System.out.println("Start");
        try {
            count.start();
            count.join(WATCH_DOG_TIMER);
            time.start();
            time.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("End");
    }


    /**
     * Class interrupter.
     */
    public class Time implements Runnable {
        /**
         * Run.
         */
        @Override
        public void run() {
            if (count != null && count.isAlive()) {
                System.out.printf("%s %s %n", "Terminate: ", count.getName());
                count.interrupt();
            }
        }
    }


    /**
     * Class counter.
     */
    public class CountChar implements Runnable {

        /**
         * Counter.
         */
        private final Counter counter;

        /**
         * Constructor initialize counter.
         *
         * @param line - words.
         */
        public CountChar(String line) {
            this.counter = new Counter(line);
        }

        /**
         * Run.
         */
        @Override
        public void run() {

            int words = this.counter.words();
            if (!count.isInterrupted()) {
                System.out.printf("%s %d %n", "Words", words);
            }
        }
    }


}
