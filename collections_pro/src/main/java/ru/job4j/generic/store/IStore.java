package ru.job4j.generic.store;

/**
 * Created by VLADIMIR on 30.05.2017.
 * @param <T> - type extends Base class.
 */
public interface IStore<T extends Base> {

    /**
     * Add value.
     * @param value - value.
     */
    void add(T value);

    /**
     * Update value.
     * @param position - position.
     * @param value - value.
     */
    void update(int position, T value);

    /**
     * Delete.
     * @param position - position.
     */
    void delete(int position);

    /**
     * Get.
     * @param position - position.
     * @return - value.
     */
    T get(int position);
}
