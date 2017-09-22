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

    private final Thread count;
    private final Thread time;

    public CountWords(String line) {
        this.count = new Thread(new CountWords.CountChar(line));
        this.time = new Thread(new CountWords.Time());
    }

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

    public class Time implements Runnable {

        /**
         * Run.
         */
        @Override
        public void run() {
            if (count != null && count.isAlive()) {
                System.out.printf("%s %s \n", "Terminate: ", count.getName());
                count.interrupt();
            }
        }
    }



    public class CountChar implements Runnable {

        private final Counter counter;

        public CountChar(String line) {
            this.counter = new Counter(line);
        }

        @Override
        public void run() {
            if (!count.isInterrupted()) {
                System.out.println(this.counter.words());
            }
        }
    }

}

class MainClass {


    public static void main(String[] args) {

        new CountWords("safasdf asdf").count();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 10000000; i++) {
            sb.append("A ");
        }

        new CountWords(sb.toString()).count();
    }


}
