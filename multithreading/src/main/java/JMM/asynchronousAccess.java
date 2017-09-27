package JMM;

/**
 * Created by VLADIMIR on 26.09.2017.
 */
public class asynchronousAccess {

    private static int x = 0;

    public static void main(String[] args) {

        new Thread(new Counter()).start();
        new Thread(new Counter()).start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(x);

    }

    static class Counter implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 500000000; i++) {
                x++;
            }
        }
    }

}


