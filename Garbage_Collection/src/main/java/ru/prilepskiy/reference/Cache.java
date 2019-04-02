package ru.prilepskiy.reference;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Cache<K, V> {

    private Map<K, SoftReference<V>> cache = new HashMap<>();

    public Optional<V> get(K key) {
        return Optional.ofNullable(this.cache.get(key)).map(r -> r.get());
    }

    public void put(K key, V value) {
        this.cache.put(key, new SoftReference<V>(value));
    }

}
