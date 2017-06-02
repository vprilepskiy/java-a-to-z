package ru.job4j.generic.store;

import ru.job4j.generic.SimpleArray;

/**
 * Created by VLADIMIR on 02.06.2017.
 */
public class AbstractStore<T extends Base> implements IStore<T> {

    /**
     * Array.
     */
    private final SimpleArray<T> values;

    /**
     * Constructor.
     * @param size - size of array.
     */
    public AbstractStore(int size) {
        this.values = new SimpleArray<>(size);
    }

    @Override
    public void add(T value) {
        this.values.add(value);
    }

    @Override
    public void update(int position, T value) {
        this.values.update(position, value);
    }

    @Override
    public void delete(int position) {
        this.values.delete(position);
    }

    @Override
    public T get(int position) {
        return this.values.get(position);
    }
}
