package example.javadoc;

/**
 * Created by VLADIMIR on 19.09.2017.
 */
public class Sleeping {

    /**
     * Sleep.
     */
    public static class SleepMessages {
        /**
         * Main class.
         * @param args args.
         * @throws InterruptedException - exception.
         */
        public static void main(String[] args)
                throws InterruptedException {
            String[] importantInfo = {
                    "Mares eat oats",
                    "Does eat oats",
                    "Little lambs eat ivy",
                    "A kid will eat ivy too"
            };

            for (int i = 0; i < importantInfo.length; i++) {
                // Pause for 4 seconds
                final int millis = 4000;
                Thread.sleep(millis);
                // Print a message
                System.out.println(importantInfo[i]);
            }
        }
    }
}
