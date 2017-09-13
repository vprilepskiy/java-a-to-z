package ru.job4j.testwork;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.TreeMap;
import java.util.ArrayList;



/**
 * Created by VLADIMIR on 11.09.2017.
 */
public class OrdersBookTest {

    /**
     * Test.
     */
    @Test
    public void sum() {

        // data
        final Order order0 = new Order(new Book("book-1", 115), 5);
        final Order order1 = new Order(new Book("book-1", 115), 10);
        final Order order2 = new Order(new Book("book-1", 118.50), 10);
        final Order order3 = new Order(new Book("book-2", 116), 2);
        final Order order4 = new Order(new Book("book-1", 118.50), -2);

        final Collection<Order> orders = Arrays.asList(order0, order1, order2, order3, order4);

        // result
        final Map<Book, Integer> result = new OrdersBook(orders).sum();

        // expect
        final Order order5 = new Order(new Book("book-1", 115), 15);
        final Order order6 = new Order(new Book("book-1", 118.50), 8);
        final Order order7 = new Order(new Book("book-2", 116), 2);

        final Map<Book, Integer> expect = new HashMap<>();

        expect.put(order5.getBook(), order5.getVolume());
        expect.put(order6.getBook(), order6.getVolume());
        expect.put(order7.getBook(), order7.getVolume());

        // assert
        Assert.assertThat(expect, Is.is(result));
    }


    /**
     * Test.
     */
    @Test
    public void cast() {

        // DATA
        final Order o1 = new Order(new Book("book-1", 99.80), -15);
        final Order o2 = new Order(new Book("book-1", 99.90), -12);
        final Order o3 = new Order(new Book("book-1", 100.30), -50);
        final Order o4 = new Order(new Book("book-1", 110.00), -1);
        final Order o5 = new Order(new Book("book-1", 100.20), 10);
        final Order o6 = new Order(new Book("book-1", 100.10), 8);
        final Order o7 = new Order(new Book("book-1", 100.00), 5);
        final Order o8 = new Order(new Book("book-1", 95.50), 2);

        final List<Order> ask = Arrays.asList(o1, o2, o3, o4);
        final List<Order> bid = Arrays.asList(o5, o6, o7, o8);

        final Map<? super Persons, List<Order>> ordersAskBid = new HashMap<>();
        ordersAskBid.put(new Persons.Ask(), ask);
        ordersAskBid.put(new Persons.Bid(), bid);

        // RESULT
        final Map<? super Persons, List<Order>> result = new OrdersBook(new ArrayList<Order>()).cast(ordersAskBid);

        // EXPECT
        final Order o10 = new Order(new Book("book-1", 99.90), -4);
        final Order o11 = new Order(new Book("book-1", 100.30), -50);

        final List<Order> expectAsk = Arrays.asList(o10, o11, o4);
        final List<Order> expectBid = Arrays.asList(o8);

        final Map<? super Persons, List<Order>> expectOrdersAskBid = new HashMap<>();
        expectOrdersAskBid.put(new Persons.Ask(), expectAsk);
        expectOrdersAskBid.put(new Persons.Bid(), expectBid);

        // ASSERT
        Assert.assertThat(result, Is.is(expectOrdersAskBid));
    }


    /**
     * Test.
     */
    @Test
    public void groupByNamePersons() {

        // DATA
        final Order o1 = new Order(new Book("book-1", 110.00), -1);
        final Order o2 = new Order(new Book("book-1", 95.50), 2);
        final Order o3 = new Order(new Book("book-2", 120.00), -3);
        final Order o4 = new Order(new Book("book-2", 90.00), 4);

        final Map<Book, Integer> orders = new HashMap<>();
        orders.put(o1.getBook(), o1.getVolume());
        orders.put(o2.getBook(), o2.getVolume());
        orders.put(o3.getBook(), o3.getVolume());
        orders.put(o4.getBook(), o4.getVolume());

        // RESULT
        final Map<String, Map<? super Persons, List<Order>>> result = new OrdersBook(new ArrayList<>()).groupByNamePersons(orders);

        // EXPECT
        final Map<String, Map<? super Persons, List<Order>>> expect = new TreeMap<>();
        List<Order> list1 = Arrays.asList(o1);
        List<Order> list2 = Arrays.asList(o2);
        List<Order> list3 = Arrays.asList(o3);
        List<Order> list4 = Arrays.asList(o4);

        final Map<? super Persons, List<Order>> innerMap1 = new HashMap<>();
        final Map<? super Persons, List<Order>> innerMap2 = new HashMap<>();

        innerMap1.put(new Persons.Ask(), Arrays.asList(o1));
        expect.put(o1.getBook().getName(), innerMap1);

        innerMap1.put(new Persons.Bid(), Arrays.asList(o2));
        expect.put(o2.getBook().getName(), innerMap1);


        innerMap2.put(new Persons.Ask(), Arrays.asList(o3));
        expect.put(o3.getBook().getName(), innerMap2);

        innerMap2.put(new Persons.Bid(), Arrays.asList(o4));
        expect.put(o4.getBook().getName(), innerMap2);

        // ASSERT
        Assert.assertThat(result, Is.is(expect));
    }
}