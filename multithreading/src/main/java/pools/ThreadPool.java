package pools;

import wait.task1.SimpleBlockingQueue;

import java.util.HashMap;
import java.util.Map;

/**
 * Конструктор создает зациклевшиеся потоки и запускает их.
 * Каждый поток берет задачу и начинает выполнять. По окончании выполнения снова берет задачу.
 */
public class ThreadPool {

    private final int cores = Runtime.getRuntime().availableProcessors();
    private final Map<Object, Thread> threads = new HashMap<>();
    private final SimpleBlockingQueue<Runnable> tasks = new SimpleBlockingQueue<>(cores * 4);

    /**
     * Конструктор создаст потоки и запустит их на выполнение.
     * Количество потоков определяется количеством ядер процессора.
     */
    public ThreadPool() {
        for (int i = 1; i <= this.cores; i++) {
            Object lock = new Object();
            this.threads.put(lock, this.runner(lock));
        }
    }

    /**
     * Добавлять задачи в блокирующую очередь tasks.
     * Разбудит ожидающие потоки.
     */
    public void work(Runnable job) throws InterruptedException {
        this.tasks.offer(job);

        for (Object lock : this.threads.keySet()) {
            synchronized (lock) {
                lock.notify();
            }
        }
    }

    /**
     * Берет задачи из очереди и выполняет их в своем потоке.
     * Если выполнение закончилось, то берет следующую.
     * Поток можно прервать методом interrupt().
     */
    private Thread runner(Object lock) {
        Thread thread = new Thread() {
            @Override
            public void run() {
                synchronized (lock) {
                    while (!Thread.currentThread().isInterrupted()) {
                        Runnable task = tasks.poll();
                        if (task != null) {
                            task.run();
                        } else {
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
                System.out.printf("%s exit %n", Thread.currentThread().getName());
            }
        };
        thread.start();
        return thread;
    }

    /**
     * Остановить выполнение.
     */
    public void shutdown() {
        for (Map.Entry<Object, Thread> entries : threads.entrySet()) {
            synchronized (entries.getKey()) {
                entries.getKey().notify();
                entries.getValue().interrupt();
            }
        }
    }


    static class Task implements Runnable {
        @Override
        public void run() {
            try {
                System.out.println("Start: " + Thread.currentThread().getName());
                Thread.sleep(1000);
                System.out.println("End: " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadPool threadPool = new ThreadPool();

        threadPool.work(new Task());
        threadPool.work(new Task());
        threadPool.work(new Task());
        threadPool.work(new Task());

        threadPool.work(new Task());
        threadPool.work(new Task());
        threadPool.work(new Task());
        threadPool.work(new Task());

        Thread.sleep(5000);
        threadPool.shutdown();
    }
}
