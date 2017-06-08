package ru.job4j.list.stack;

/**
 * Created by VLADIMIR on 08.06.2017.
 * @param <E> - generic.
 */
public interface ISimpleContainer<E> {

    /**
     * Добавляет элемент.
     * @param value - value.
     */
    void push(E value);

    /**
     * Возвращает элемент и удаляет его.
     * @return - value.
     */
    E pop();

}
