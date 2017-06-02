package ru.job4j.generic;

/**
 * 5.2.1. Реализовать SimpleArray<T>.
 * Доделать контейнер SimpleArray<T> добавить методы add, update, delete, get(int index);
 *
 * Created by VLADIMIR on 29.05.2017.
 *
 * @param <T> - Generic.
 */
public class SimpleArray<T> {

    /**
     * Массив для хранения объектов.
     */
    private Object[] objects;
    /**
     * Индекс последней свободной ячейки.
     */
    private int index = 0;

    /**
     * Конструктор.
     * @param size - размер массива.
     */
    public SimpleArray(int size) {
        this.objects = new Object[size];
    }


    /**
     * Добавить элемент.
     * @param value - значение.
     */
    public void add(T value) {
        this.objects[index++] = value;
    }


    /**
     * Обновить значение.
     * @param position - номер ячейки.
     * @param value - значение.
     */
    public void update(int position, T value) {
        this.objects[position] = value;
    }


    /**
     * Удалить элемент.
     * @param position - номер ячейки.
     */
    public void delete(int position) {
        System.arraycopy(this.objects, position + 1, this.objects, position, this.index - position - 1);
        if ((this.objects.length - 1) >= position) {
            this.objects[this.index - 1] = null;
        }
    }


    /**
     * Получить значение.
     * @param position - номер ячейки.
     * @return - значение.
     */
    public T get(int position) {
        return (T) this.objects[position];
    }
}


