package ru.prilepskiy.instrument.monitoring;

public class Item {

    public Item(long used, long free, long total, long max) {
        this.used = used;
        this.free = free;
        this.total = total;
        this.max = max;
    }

    long used;
    long free;
    long total;
    long max;

    public Item different(Item item) {
        return new Item(
            used - item.used,
            free - item.free,
            total - item.total,
            max - item.max);
    }

    public Item print(String info) {
        System.out.printf("##### Heap utilization statistics [KB]: %s #####%n", info);
        System.out.printf("Used Memory: %d%n", this.used);
        System.out.printf("Free Memory: %d%n", this.free);
        System.out.printf("Total Memory: %d%n", this.total);
        System.out.printf("Max Memory: %d%n", this.max);
        return this;
    }
}
