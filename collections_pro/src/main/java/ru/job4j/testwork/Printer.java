package ru.job4j.testwork;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by VLADIMIR on 13.09.2017.
 */
public class Printer {

    /**
     * Constructor.
     * @param market - K - bookName, V - (K - Ask|Bid, V - orders)
     */
    public Printer(Map<String, Map<? super Persons, List<Order>>> market) {
        this.market = market;
    }

    /**
     * Market.
     */
    private final Map<String, Map<? super Persons, List<Order>>> market;

    /**
     * Print.
     */
    public void print() {

        for (Map.Entry<String, Map<? super Persons, List<Order>>> entry : this.market.entrySet()) {
            String bookName = entry.getKey();
            Map<? super Persons, List<Order>> orders = entry.getValue();

            System.out.print("BOOK: ");
            System.out.println(bookName);
            this.printOrders(orders);
        }

    }


    /**
     * Print orders.
     * @param orders - orders.
     */
    private void printOrders(Map<? super Persons, List<Order>> orders) {

        // Bid Ask
        System.out.print(new Persons.Bid().getName());
        System.out.print('\t');
        System.out.print(new Persons.Ask().getName());
        System.out.println();
        System.out.println("Volume@Price – Volume@Price");

        List<Order> bid = orders.get(new Persons.Bid());
        List<Order> ask = orders.get(new Persons.Ask());

        Iterator<Order> itBid = bid.iterator();
        Iterator<Order> itAsk = ask.iterator();

        while (itBid.hasNext() || itAsk.hasNext()) {
            if (itBid.hasNext()) {
                System.out.print(itBid.next().print());
            } else {
                System.out.print("-----------");
            }

            if (itAsk.hasNext()) {
                System.out.print(itAsk.next().print());
            } else {
                System.out.print("-----------");
            }

            System.out.println();
        }
    }

}
