package ru.job4j.generic.store;

import ru.job4j.generic.SimpleArray;

/**
 * Created by VLADIMIR on 30.05.2017.
 *
 * Хранилище ролей.
 */
public class RoleStore extends AbstractStore<Role> {

    /**
     * Constructor.
     *
     * @param size - size of array.
     */
    public RoleStore(int size) {
        super(size);
    }

}
