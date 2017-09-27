package JMM;

/**
 * Created by VLADIMIR on 26.09.2017.
 */
public class asynchronousAccess2 {



    private int x = 0;
    private int y = 0;

    public static void main(String[] args) {
        new asynchronousAccess2().aVoid();

    }

    public void aVoid() {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                new Thread(new Counter()).start();
                new Thread(new Counter()).start();
            }
        });

        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(this.x);
    }

    class Counter implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 500000000; i++) {
                x++;
            }
            System.out.println("End");
        }
    }

}
