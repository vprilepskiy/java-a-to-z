package wait.task2;

import wait.task1.SimpleBlockingQueue;

public class ParallelSearch {

    private volatile static Thread consumer;
    private volatile static Thread producer;

    public static void main(String[] args) {
        final SimpleBlockingQueue<Integer> queue = new SimpleBlockingQueue<>(2);

        consumer = new Thread(() -> {
                while (producer.getState() != Thread.State.TERMINATED || queue.size() != 0) {
                    System.out.println(queue.poll());
                    try {
                        Thread.sleep(30);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        );

        producer = new Thread(() -> {
            for (int index = 0; index != 3; index++) {
                try {
                    queue.offer(index);
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        consumer.start();
        producer.start();
    }
}
