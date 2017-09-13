package ru.job4j.testwork;

import java.io.File;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Created by VLADIMIR on 13.09.2017.
 */
public class MainClass {

    /**
     * Main method.
     * @param args - args.
     */
    public static void main(String[] args) {

        final String fileName = "C:\\Downloads\\orders.xml";

        final long start = System.currentTimeMillis();

        Collection<Order> orders = new XMLParse(new File(fileName)).read();
        OrdersBook ordersBook = new OrdersBook(orders);
        Map<Book, Integer> ordersSum = ordersBook.sum();
        Map<String, Map<? super Persons, List<Order>>> market = ordersBook.groupByNamePersons(ordersSum);
        new Printer(market).print();

        System.out.println(new StringBuilder("Run time: ").append(System.currentTimeMillis() - start).append(" ms."));
    }
}
