package ru.job4j.performance;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.TreeSet;

/**
 * Created by vladimir on 27.04.2017.
 */
public class ThroughputTest {

    /**
     * Добавит и удалит записи в коллекции.
     * @param collection - коллекция.
     */
    private void addAndDelElements(Collection<String> collection) {

        final String line = "String line";
        final int addAmount = (int) Math.pow(8, 7);
        final int delAmount = (int) Math.pow(8, 4);

        Throughput throughput = new Throughput();

        System.out.print("\tadd:\t");
        System.out.println(throughput.add(collection, line, addAmount));

        System.out.print("\tdelete:\t");
        System.out.println(throughput.delete(collection, delAmount));
    }

    /**
     * Выводит в консоль время выполнения методов.
     */
    @Test
    public void test() {

        System.out.println("LinkedList");
        this.addAndDelElements(new LinkedList<String>());

        System.out.println("ArrayList");
        this.addAndDelElements(new ArrayList<String>());

        System.out.println("TreeSet");
        this.addAndDelElements(new TreeSet<String>());
    }
}

