package ru.job4j.generic.store;

/**
 * Created by VLADIMIR on 30.05.2017.
 *
 * Хранилище пользователей.
 */
public class UserStore extends AbstractStore<User> {

    /**
     * Constructor.
     *
     * @param size - size of array.
     */
    public UserStore(int size) {
        super(size);
    }

}
