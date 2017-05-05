package ru.job4j.performance;

import java.util.Collection;
import java.util.Iterator;

/**
 * Created by vladimir on 27.04.2017.
 */
public class Throughput implements IThroughput {

    @Override
    public long add(Collection<String> collection, String line, int amount) {

        long start = System.currentTimeMillis();

        for (int i = 0; i < amount; i++) {
            collection.add(new StringBuilder(line).append(Math.random()).toString());
        }

        return System.currentTimeMillis() - start;
    }

    @Override
    public long delete(Collection<String> collection, int amount) {

        long start = System.currentTimeMillis();

        Iterator iterator = collection.iterator();
        for (int i = 0; i < amount; i++) {
            if (iterator.hasNext()) {
                iterator.next();
                iterator.remove();
            }
        }

        return System.currentTimeMillis() - start;
    }
}
