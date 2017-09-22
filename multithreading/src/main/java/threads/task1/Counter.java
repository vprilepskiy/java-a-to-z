package threads.task1;

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


