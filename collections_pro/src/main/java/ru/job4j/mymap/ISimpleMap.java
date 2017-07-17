package ru.job4j.mymap;

/**
 * Created by VLADIMIR on 11.07.2017.
 */

/**
 * Interface for simple map.
 * @param <K> - key.
 * @param <V> - value.
 */
public interface ISimpleMap<K, V> {

    /**
     * Insert or replace the pair (key value).
     * @param key - key.
     * @param value - value.
     * @return - true if Insert or replace.
     */
    boolean insert(K key, V value);

    /**
     * Get value by key.
     * @param key - key.
     * @return - value.
     */
    V get(K key);

    /**
     * Delete value by key.
     * @param key - key.
     * @return - true if delete.
     */
    boolean delete(K key);
}
