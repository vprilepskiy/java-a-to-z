package ru.job4j.list.linkedlist;

import ru.job4j.list.ISimpleContainer;

import java.util.Iterator;

/**
 * Created by VLADIMIR on 05.06.2017.
 */
public class SimpleContainer<E> implements ISimpleContainer<E> {

    /**
     * Первый элемент.
     */
    private Element<E> firstElement;

    /**
     * Последний элемент.
     */
    private Element<E> lastElement;

    @Override
    public void add(E value) {
        // создать новый элемент
        Element<E> newElement = new Element<E>(value);

        // добавить ссылку о новом элементе в текущий
        if (this.lastElement != null) {
            this.lastElement.setNext(newElement);
        }

        // передать ссылку о новом элементе в текущий
        this.lastElement = newElement;

        // добавить информацию о первом элементе
        if (this.firstElement == null) {
            this.firstElement = newElement;
        }
    }

    @Override
    public E get(int index) {
        E value = null;

        java.util.Iterator iterator = this.iterator();
        for (int i = 0; i < index; i++) {
//            value = iterator.next();
        }

        return value;
    }

    @Override
    public Iterator iterator() {
        return new Iterator<E>() {

            /**
             * Текущий элемент.
             */
            private Element<E> element = firstElement;

            @Override
            public boolean hasNext() {
                return this.element != null;
            }

            @Override
            public E next() {
                // получить значение элемента
                E value = this.element.getValue();

                // сдвинуться на один элемент вправо
                this.element = this.element.getNext();

                return value;
            }
        };
    }
}

/**
 * Element of linkedList.
 * @param <E> - type value.
 */
class Element<E>{

//    private final Element<E> prev;
    private final E value;
    private Element<E> next;

    public Element(E value) {
//        this.prev = prev;
        this.value = value;
    }


//    public Element(Element<E> prev, E value) {
//        this.prev = prev;
//        this.value = value;
//    }

//
//    public Element<E> getPrev() {
//        return prev;
//    }

    public E getValue() {
        return value;
    }

    public Element<E> getNext() {
        return next;
    }

    public void setNext(Element<E> next) {
        this.next = next;
    }
}

