package example.arsentiev;

/**
 * Created by VLADIMIR on 15.09.2017.
 */
public class AsinchOperations {

    public static final class Calculate implements Runnable {

        @Override
        public void run() {
            System.out.println("TODO async");
        }
    }

    public void a() {
        System.out.println("start");
        new Thread(new Calculate()).start();
        System.out.println("finish");
    }

    public static void main(String[] args) {
        new AsinchOperations().a();
    }

}
