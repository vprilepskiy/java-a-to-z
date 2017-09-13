package ru.job4j.testwork;

import java.util.List;
import java.util.Map;

/**
 * Created by VLADIMIR on 08.09.2017.
 */
public interface IOrdersBook {

    /**
     * Просуммировать все ордеры по полю Volume.
     * @return - orders. (K - Book, V - volume).
     */
    Map<Book, Integer> sum();


    /**
     * Разделить по типу акции (bookName) и разделить на Bid и Ask.
     * @param orders - K - Book, V - volume.
     * @return - K - bookName, V - (K - Ask|Bid, V - orders)
     */
    Map<String, Map<? super Persons, List<Order>>> groupByNamePersons(Map<Book, Integer> orders);


    /**
     * Сократить Bid и Ask.
     * @param orders - K - Ask|Bid, V - orders
     * @return - K - Ask|Bid, V - orders
     */
    Map<? super Persons, List<Order>> cast(Map<? super Persons, List<Order>> orders);
}
