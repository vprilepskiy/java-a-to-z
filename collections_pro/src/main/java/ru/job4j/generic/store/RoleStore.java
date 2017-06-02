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

//    /**
//     * Array.
//     */
//    private final SimpleArray<Role> roles;
//
//    /**
//     * Constructor.
//     * @param size - size of array.
//     */
//    public RoleStore(int size) {
//        this.roles = new SimpleArray<>(size);
//    }
//
//    @Override
//    public void add(Role value) {
//        this.roles.add(value);
//    }
//
//    @Override
//    public void update(int position, Role value) {
//        this.roles.update(position, value);
//    }
//
//    @Override
//    public void delete(int position) {
//        this.roles.delete(position);
//    }
//
//    @Override
//    public Role get(int position) {
//        return this.roles.get(position);
//    }
}
