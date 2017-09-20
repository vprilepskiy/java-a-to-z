package example.javadoc;

/**
 * Created by VLADIMIR on 19.09.2017.
 */
public class Interruptting {
    /**
     * Thread.
     */
    private final Thread t0 = new Thread0();
    /**
     * Thread.
     */
    private final Thread t1 = new Thread1();
    /**
     * Thread.
     */
    private final Thread t2 = new Thread2();

    /**
     * Main.
     * @param args - args.
     * @throws InterruptedException - exception.
     */
    public static void main(String[] args) throws InterruptedException {
        Interruptting interruptting = new Interruptting();
        interruptting.t0.start();
        interruptting.t1.start();
        interruptting.t2.start();
    }


    /**
     * Thread. Зациклившийся метод.
     */
    public class Thread0 extends Thread {
        /**
         * Run.
         */
        public void run() {
            int i = 0;
            while (true) {
                // проверка: вдруг меня уже прервали
                if (this.isInterrupted()) {
                    break;
                }
                // тут чтото происходит
                i++;
                i--;
            }
        }
    }


    /**
     * Thread. Монитор.
     */
    public class Thread1 extends Thread {
        /**
         * Run.
         */
        public void run() {
            final int number = 15;
            for (int i = 0; i < number; i++) {
                System.out.print("Thread: " + t0);
                System.out.print(", isInterrupted: " + t0.isInterrupted());
                System.out.println(", isAlive: " + t0.isAlive());
                try {
                    final int millis = 500;
                    this.sleep(millis);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    /**
     * Thread. Прерыватель.
     */
    public class Thread2 extends Thread {
        /**
         * Run.
         */
        public void run() {

            final int millis = 1500;

            try {
                this.sleep(millis);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(" 1 interrupt();");
            t0.interrupt();

            try {
                this.sleep(millis);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(" 2 interrupt();");
            t0.interrupt();
        }
    }
}
