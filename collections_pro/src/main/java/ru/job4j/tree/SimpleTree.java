package ru.job4j.tree;

/**
 * Created by VLADIMIR on 24.07.2017.
 * @param <E> - type class.
 */
public interface SimpleTree<E extends Comparable<E>> extends Iterable<E> {
    /**
     * Добавить элемент child в parent.
     * Parent может иметь список child.
     * @param parent - parent.
     * @param child - child.
     * @return - True - if the tree is empty. True - if a parent is found.
     */
    boolean add(E parent, E child);

    /**
     * Проверяет количество дочерних элементов в дереве.
     * @return Если элементов в дереве <= 2 - то дерево бинарное.
     */
    boolean isBinary();
}

