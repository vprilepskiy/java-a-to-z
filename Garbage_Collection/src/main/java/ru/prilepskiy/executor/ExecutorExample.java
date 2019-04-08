package ru.prilepskiy.executor;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Пул потоков.
 */
public class ExecutorExample {

    public static void main(String[] args) {
        ExecutorService pool = null;
        try {
            pool = Executors.newFixedThreadPool(2);
            pool.submit(new RunnableImpl());
            pool.submit(new CallableImpl());
        } finally {
            pool.shutdown();
        }
    }


    static class RunnableImpl implements Runnable {
        @Override
        public void run() {
            System.out.println("Runnable");
        }
    }

    static class CallableImpl implements Callable<Integer> {
        @Override
        public Integer call() throws Exception {
            System.out.println("Callable");
            return 1;
        }
    }

}
