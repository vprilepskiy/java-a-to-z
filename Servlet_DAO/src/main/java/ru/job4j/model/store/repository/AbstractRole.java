package ru.job4j.model.store.repository;

import java.util.Set;

/**
 * Created by VLADIMIR on 31.01.2018.
 */
public abstract class AbstractRole {

    /**
     * Role.
     */
    ru.job4j.model.entity.Role role;

    /**
     * Users.
     */
    Set<ru.job4j.model.entity.User> users;

    /**
     * операция получения всех связанных с ним сущностей
     */
    public abstract void read();


    /**
     * Setter.
     * @param role - role.
     */
    public void setRole(ru.job4j.model.entity.Role role) {
        this.role = role;
    }

    /**
     * Getter.
     * @return - users.
     */
    public Set<ru.job4j.model.entity.User> getUsers() {
        return this.users;
    }

}
