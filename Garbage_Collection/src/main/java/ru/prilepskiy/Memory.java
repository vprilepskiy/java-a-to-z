package ru.prilepskiy;

public class Memory {

    public static void info() {
        final int mb = 1024 * 1024;
        final Runtime runtime = Runtime.getRuntime();

        System.out.println("##### Heap utilization statistics [MB] #####");

        System.out.println("Used Memory" + (runtime.totalMemory() - runtime.freeMemory() / mb));
        System.out.println("Free Memory" +  runtime.freeMemory() / mb);
        System.out.println("Total Memory" + runtime.totalMemory() / mb);
        System.out.println("Max Memory" + runtime.maxMemory() / mb);
    }
}
