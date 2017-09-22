package threads.task1;

/**
 * Created by VLADIMIR on 22.09.2017.
 */
public class MainClass {

    /**
     * Main class.
     *
     * @param args - args.
     */
    public static void main(String[] args) {

        final Counter counter = new Counter("Hello Job4j");

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.format("Space: %d%n", counter.space());
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.format("Words: %d%n", counter.words());
            }
        }).start();
    }
}


