package ru.job4j.testwork;


import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Comparator;
import java.util.Set;
import java.util.Collection;
import java.util.HashMap;
import java.util.TreeSet;


/**
 * Created by VLADIMIR on 11.09.2017.
 */
public class OrdersBook implements IOrdersBook {

    /**
     * Constructor.
     * @param orders - orders.
     */
    public OrdersBook(Collection<Order> orders) {
        this.orders = orders;
    }

    /**
     * Orders.
     */
    private final Collection<Order> orders;

    @Override
    public Map<Book, Integer> sum() {

        final Map<Book, Integer> orderSum = new HashMap<>();

        // пройдем по всем ордерам
        for (Order order : this.orders) {

            // key
            Book book = order.getBook();
            // value
            Integer volume = order.getVolume();

            // found value
            Integer valueSum = orderSum.get(book);

            // если ордер найден
            if (valueSum != null) {

                // если сумма ордера равна 0, то удалить ордер, если нет то сложить
                if ((valueSum + volume) == 0) {
                    orderSum.remove(book);
                } else {
                    orderSum.replace(book, valueSum + volume);
                }

                // если орден не найден, то добавить
            } else {
                orderSum.put(book, volume);
            }
        }
        return orderSum;
    }



    @Override
    public Map<String, Map<? super Persons, List<Order>>> groupByNamePersons(Map<Book, Integer> orders) {

        Map<String, Map<? super Persons, List<Order>>> map = new TreeMap<>();

        // названия книг
        final Set<String> names = new TreeSet();
        for (Book book : orders.keySet()) {
            names.add(book.getName());
        }

        // пройдемся по названиям книг
        for (String bookName : names) {

            List<Order> buy = new LinkedList<>();
            List<Order> sell = new LinkedList<>();

            // пройдемся по ордерам
            for (Map.Entry<Book, Integer> entry : orders.entrySet()) {

                Book book = entry.getKey();
                Integer volume = entry.getValue();

                // проверка книги по имени
                if (bookName.equals(book.getName())) {

                    // добавляем в разные коллекции (BUY, SELL)
                    if (volume < 0) {
                        buy.add(new Order(book, volume));
                    } else {
                        sell.add(new Order(book, volume));
                    }
                }
            }

            // отсортировать коллекции
            buy.sort(new Comparator<Order>() {
                @Override
                public int compare(Order o1, Order o2) {
                    return o1.compareTo(o2);
                }
            });

            sell.sort(new Comparator<Order>() {
                @Override
                public int compare(Order o1, Order o2) {
                    return o2.compareTo(o1);
                }
            });

            // добавить Ask и Bid
            Map<? super Persons, List<Order>> ordersAskBid = new HashMap<>();

            ordersAskBid.put(new Persons.Ask(), buy);
            ordersAskBid.put(new Persons.Bid(), sell);

            // выполнить метод сокращения ордеров.
            ordersAskBid = this.cast(ordersAskBid);

            // добавить в результирующий набор
            map.put(bookName, ordersAskBid);
        }
        return map;
    }



    @Override
    public Map<? super Persons, List<Order>> cast(Map<? super Persons, List<Order>> orders) {
        Map<? super Persons, List<Order>> ordersAskBid = new HashMap<>();

        List<Order> askList = new LinkedList<>(orders.get(new Persons.Ask()));
        List<Order> bidList = new LinkedList<>(orders.get(new Persons.Bid()));

        boolean again = false;

        do {

            Order askOrder = askList.get(0);
            Order bidOrder = bidList.get(0);

            // проверяем по цене книги. Если цена продавца < цены покупателя
            if ((askOrder.getBook().getPrice()) <= (bidOrder.getBook().getPrice())) {
                again = true;

                int volume = askOrder.getVolume() + bidOrder.getVolume();

                // если при складывании ордеров получается ноль
                if (volume == 0) {
                    // ордеры сокращаются
                    askList.remove(0);
                    bidList.remove(0);
                } else if (volume > 0) {
                    bidOrder.setVolume(volume);
                    askList.remove(0);
                } else if (volume < 0) {
                    askOrder.setVolume(volume);
                    bidList.remove(0);
                }
            } else {
                again = false;
            }

            if (askList.size() == 0 || bidList.size() == 0) {
                again = false;
            }

        } while (again);

        ordersAskBid.put(new Persons.Ask(), askList);
        ordersAskBid.put(new Persons.Bid(), bidList);

        return ordersAskBid;
    }
}
