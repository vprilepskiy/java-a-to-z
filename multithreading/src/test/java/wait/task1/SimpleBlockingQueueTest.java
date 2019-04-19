package wait.task1;

import org.junit.Assert;
import org.junit.Test;

public class SimpleBlockingQueueTest {

    private final SimpleBlockingQueue<String> queue = new SimpleBlockingQueue<>(2);

    @Test
    public void test() throws InterruptedException {
        queue.offer("1");
        queue.offer("2");

        Assert.assertEquals(queue.poll(), "1");
        Assert.assertEquals(queue.poll(), "2");
    }
}