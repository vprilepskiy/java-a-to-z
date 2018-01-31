package ru.job4j.model.store.repository;

/**
 * Created by VLADIMIR on 31.01.2018.
 */
public class Role extends AbstractRole {

    /**
     * Constructor.
     * @param role - role.
     */
    public Role(ru.job4j.model.entity.Role role) {
        this.role = role;
    }


    @Override
    public void read() {
        User user = new User();
        user.setRole(this.role);
        user.find();
        this.users = user.getUsers();
    }
}
