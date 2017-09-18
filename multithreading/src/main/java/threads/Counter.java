package threads;

/**
 * Created by VLADIMIR on 18.09.2017.
 */
public class Counter {

    /**
     * Text.
     */
    private final String line;

    /**
     * Constructor.
     * @param line - text.
     */
    public Counter(String line) {
        this.line = line;
    }

    /**
     * Count number of space.
     * @return - number.
     */
    public int space() {
        return this.line.length() - this.line.replace(" ", "").length();
    }

    /**
     * Count number of words.
     * @return - number.
     */
    public int words() {
        return this.line.split(" ").length;
    }
}

/**
 * Thread.
 */
class Thread0 extends Thread {
    public void run() {
        System.out.format("Space: %d%n", new Counter("Hello Job4j").space());
    }
}

/**
 * Thread.
 */
class Thread1 extends Thread {
    public void run() {
        System.out.format("Words: %d%n", new Counter("Hello Job4j").words());
    }
}

/**
 * Run threads.
 */
class MainClass {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread0().start();
            new Thread1().start();
        }
    }
}


