package ru.prilepskiy.futures;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class CallableExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        final CallableImpl callable = new CallableImpl();
        final FutureTask<Integer> task = new FutureTask<>(callable);

        new Thread(task).start();
        System.out.println("Выполнился?: " + task.isDone());
        System.out.println("Ждать выполнения и запросить результат: " + task.get());
        System.out.println("Ждать выполнения максимум 5мс. и запросить результат: " + task.get(5, TimeUnit.MILLISECONDS));
        System.out.println("Выполнился?: " + task.isDone());
    }

    public static class CallableImpl implements Callable<Integer> {
        @Override
        public Integer call() throws Exception {
            Integer result = 0;
            for (int i = 0; i < 500_000_000; i++) {
                result = i;
            }
            return result;
        }
    }

}
