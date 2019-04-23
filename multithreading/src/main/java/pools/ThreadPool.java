package pools;

import wait.task1.SimpleBlockingQueue;

import java.util.HashSet;
import java.util.Set;

/**
 * Конструктор создает зациклевшиеся потоки и запускает их.
 * Каждый поток берет задачу и начинает выполнять. По окончании выполнения снова берет задачу.
 */
public class ThreadPool {

    private final int cores = Runtime.getRuntime().availableProcessors();
    private final Set<Thread> threads = new HashSet<>();
    private final SimpleBlockingQueue<Runnable> tasks = new SimpleBlockingQueue<>(cores * 4);

    /**
     * Конструктор создаст потоки и запустит их на выполнение.
     * Количество потоков определяется количеством ядер процессора.
     */
    public ThreadPool() {
        for (int i = 1; i <= this.cores; i++) {
            this.threads.add(this.runner());
        }
    }

    /**
     * Добавлять задачи в блокирующую очередь tasks.
     */
    public void work(Runnable job) throws InterruptedException {
        this.tasks.offer(job);
    }

    /**
     * Берет задачи из очереди и выполняет их в своем потоке.
     * Если выполнение закончилось, то берет следующую.
     * Поток можно прервать методом interrupt().
     */
    private Thread runner() {
        Thread thread = new Thread() {
            @Override
            public void run() {
                while (!Thread.currentThread().isInterrupted() || tasks.size() > 0) {
                    Runnable task = tasks.poll();
                    if (task != null) {
                        task.run();
                    }
                }
                System.out.printf("%s exit %n", Thread.currentThread().getName());
            }
        };
        thread.start();
        return thread;
    }

    /**
     * Выполнить оставшиеся задания и остановится.
     */
    public void shutdown() {
        threads.forEach(thread -> thread.interrupt());
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
