package ru.job4j.set.quickadd;

import ru.job4j.list.ISimpleContainer;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Created by VLADIMIR on 15.06.2017.
 * @param <E> - generic.
 */
public class SimpleSet<E> implements ISimpleContainer<E> {

    /**
     * Default size of container.
     */
    private final int defaultSize = 10;
    /**
     * Array of objects.
     */
    private Object[] container;
    /**
     * Index for array container.
     */
    private int index = 0;
    /**
     * Hash code of objects. Sorted array.
     */
    private int[] hash;
    /**
     * Index for array hash.
     */
    private int indexHash = 0;



    /**
     * Constructor.
     */
    public SimpleSet() {
        this.container = new Object[this.defaultSize];
        this.hash = new int[this.defaultSize];
    }

    /**
     * Constructor witch size of array.
     * @param size - size of array.
     */
    public SimpleSet(int size) {
        this.container = new Object[size];
        this.hash = new int[size];
    }



    @Override
    public void add(E value) {

        // Ключ для поиска элемента. Если положительное, то найден. Если отрицательное то указывает на место вставки.
        int searchKey = Arrays.binarySearch(this.hash, 0, this.indexHash, value.hashCode());

        // если элемент не найден
        if (searchKey < 0) {
            // расширить массив и добавить элемент
            if (this.index > (this.container.length - 1)) {
                this.container = Arrays.copyOf(this.container, this.container.length * 2);
            }
            this.container[this.index++] = value;

            // добавить HashCode
            this.addHash((Math.abs(searchKey) - 1), value);
        }
    }


    /**
     * Вставляет hashCode в массив в отсортированном порядке.
     * @param indexHash - место для вставки.
     * @param value - объект.
     */
    private void addHash(int indexHash, E value) {
        // если требуется расширить массив
        if (this.indexHash > (this.hash.length - 1)) {
            // расширить массив в два раза
            this.hash = Arrays.copyOf(this.hash, this.hash.length * 2);
        }
        // если вставка в конец массива
        if ((this.indexHash) > indexHash) {
            this.hash[this.indexHash++] = value.hashCode();
            // если вставка в середину массива
        } else {
            this.addInMiddle(this.hash, indexHash, value.hashCode());
            this.indexHash++;
        }
    }



    /**
     * Добавит элемент в середину массива. Последний элемент потеряется.
     * @param array - массив.
     * @param index - идекс ячейки для вставки.
     * @param value - значение для вставки.
     */
    void addInMiddle(int[] array, int index, int value) {
        // сдвинуть вправо от индекса
        System.arraycopy(array, index, array, index + 1, array.length - index - 1);
        // вставить значение
        array[index] = value;
    }



    @Override
    public E get(int index) {
        return (E) this.container[index];
    }



    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            private int itIndex = 0;

            @Override
            public boolean hasNext() {
                return index > this.itIndex;
            }

            @Override
            public E next() {
                return (E) container[this.itIndex++];
            }
        };
    }
}
