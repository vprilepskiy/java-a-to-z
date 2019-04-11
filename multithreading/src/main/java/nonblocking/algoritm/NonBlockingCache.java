package nonblocking.algoritm;

import java.util.concurrent.ConcurrentHashMap;

public class NonBlockingCache {

    private final ConcurrentHashMap<Integer, Base> map = new ConcurrentHashMap<>();

    /**
     * Добавить элемент.
     */
    public Base add(Base base) {
        return this.map.putIfAbsent(base.getId(), base);
    }

    /**
     * Найти элемент и проверить версию. Если версия такаяже, то увеличит версию.
     */
    public Base update(Base base) {
        return this.map.computeIfPresent(base.getId(), (k, v) -> {
            if (base.equals(v)) {
                v.setVersion(v.getVersion() + 1);
            } else {
                throw new OptimisticException();
            }
            return v;
        });
    }

    /**
     * Удалить элемент.
     */
    public Base delete(Base base) {
        return this.map.remove(base.getId());
    }
}
