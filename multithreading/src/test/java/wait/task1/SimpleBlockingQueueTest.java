package wait.task1;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SimpleBlockingQueueTest {

    SimpleBlockingQueue<String> queue = new SimpleBlockingQueue<String>(2);

    @Test
    public void test() throws InterruptedException {

        final Thread producer = new Thread(() -> {
            try {
                queue.offer("1");
                queue.offer("2");
                queue.offer("3");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        final Thread customer = new Thread(() -> {
            Assert.assertEquals(queue.poll(), "1");
        });

        producer.start();
        producer.join(1000);
        customer.start();
    }
}