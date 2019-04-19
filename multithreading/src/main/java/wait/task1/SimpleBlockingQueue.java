package wait.task1;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Синхронизатор Semaphore.
 */
@ThreadSafe
public class SimpleBlockingQueue<T> {

    public SimpleBlockingQueue(int permitSize) {
        this.permitSize = permitSize;
    }

    private final int permitSize;
    private final Object lock = new Object();

    @GuardedBy("this")
    private final Queue<T> queue = new LinkedList<T>();

    public void offer(T value) throws InterruptedException {
        synchronized(this.lock) {
            if (this.queue.size() >= this.permitSize) {
                this.lock.wait();
            }
            this.queue.offer(value);
        }
    }

    public T poll() {
        synchronized(this.lock) {
            this.lock.notify();
            return this.queue.poll();
        }
    }
}
