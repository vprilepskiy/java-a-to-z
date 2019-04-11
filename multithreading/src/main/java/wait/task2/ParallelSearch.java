package wait.task2;

import wait.task1.SimpleBlockingQueue;

import java.util.concurrent.atomic.AtomicBoolean;

public class ParallelSearch {

    public static void main(String[] args) {
        final SimpleBlockingQueue<Integer> queue = new SimpleBlockingQueue<>(2);
        AtomicBoolean isAlive = new AtomicBoolean(true);

        final Thread consumer = new Thread(() -> {
                while (isAlive.get()) {
                    System.out.println(queue.poll());
                }
            }
        );

        final Thread producer = new Thread(() -> {
            for (int index = 0; index != 3; index++) {
                try {
                    queue.offer(index);
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            isAlive.set(false);
        });

        consumer.start();
        producer.start();
    }
}
