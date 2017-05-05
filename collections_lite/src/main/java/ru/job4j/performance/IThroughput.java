package ru.job4j.performance;

import java.util.Collection;

/**
 * Created by vladimir on 27.04.2017.
 *
 * Написать программу, которая замеряет время вставки в коллекцию большого количества случайных строк и удаления в коллекции первых n элементов для:
 * LinkedList
 * ArrayList
 * TreeSet
 */
public interface IThroughput {

    /**
     * Добавить записи в коллекцию.
     * @param collection - коллекция.
     * @param line - запись.
     * @param amount - кол-во записей.
     * @return - время (мс) выполнения.
     */
    long add(Collection<String> collection, String line, int amount);

    /**
     * Удалить записи из коллекции.
     * @param collection - коллекция.
     * @param amount - кол-во записей
     * @return - время (мс) выполнения.
     */
    long delete(Collection<String> collection, int amount);

}