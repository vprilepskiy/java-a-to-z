package example.arsentiev;

public class ProducerCustomer {

    private final Object lock = new Object();
    private boolean blockCustomer = true;
    //Customer
    public void doSomething() throws InterruptedException {
        synchronized (this.lock) {
            while (this.blockCustomer) {
                this.lock.wait();
            }
        }
    }
    //Producer
    public void changeBlock(boolean enable) {
        synchronized (this.lock) {
            this.blockCustomer = enable;
            this.lock.notify();
        }
    }

    public static void main(String[] args) {
        final ProducerCustomer producerCustomer = new ProducerCustomer();

        //Producer
        new Thread() {
            @Override
            public void run() {
                producerCustomer.changeBlock(false);
            }
        }.start();

        //Customer
        new Thread() {
            @Override
            public void run() {
                try {
                    producerCustomer.doSomething();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
}
