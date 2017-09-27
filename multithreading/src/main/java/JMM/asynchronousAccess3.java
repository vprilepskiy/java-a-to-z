package JMM;

/**
 * Created by VLADIMIR on 26.09.2017.
 */
public class asynchronousAccess3 {

    public static void main(String[] args) {
        new asynchronousAccess3().count();
    }

    private int x = 0;



    public void count() {

        Thread thread1 = new Thread(new Counter());
        Thread thread2 = new Thread(new Counter());

        thread1.start();
        thread2.start();

        while (thread1.isAlive() || thread2.isAlive()) {
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
