package ru.job4j.generic.store;

import ru.job4j.generic.SimpleArray;

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

//    /**
//     * Array.
//     */
//    private final SimpleArray<User> users;
//
//    /**
//     * Constructor.
//     * @param size - size of array.
//     */
//    public UserStore(int size) {
//        this.users = new SimpleArray<>(size);
//    }
//
//    @Override
//    public void add(User value) {
//        this.users.add(value);
//    }
//
//    @Override
//    public void update(int position, User value) {
//        this.users.update(position, value);
//    }
//
//    @Override
//    public void delete(int position) {
//        this.users.delete(position);
//    }
//
//    @Override
//    public User get(int position) {
//        return this.users.get(position);
//    }
}
