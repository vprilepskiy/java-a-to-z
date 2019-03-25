package ru.prilepskiy.instrument.monitoring;

public class Memory {

    public Item calculate() {
        final int kb = 1024;
        final Runtime runtime = Runtime.getRuntime();

        long used = ((runtime.totalMemory() - runtime.freeMemory()) / kb);
        long free = runtime.freeMemory() / kb;
        long total = runtime.totalMemory() / kb;
        long max = runtime.maxMemory() / kb;

        return new Item(used, free, total, max);
    }
}
