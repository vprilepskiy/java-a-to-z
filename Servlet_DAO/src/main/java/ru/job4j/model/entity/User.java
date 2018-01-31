package ru.job4j.model.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Created by VLADIMIR on 26.01.2018.
 */
public class User extends AbstractEntity {

    private final String name;

    private final String login;

    private final String password;

    private final String email;

    private int roleId = -1;

    public User(int id, String name, String login, String password, String email, int roleId) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.password = password;
        this.email = email;
        this.roleId = roleId;
    }

    public User(String name, String login, String password, String email, int roleId) {
        this.name = name;
        this.login = login;
        this.password = password;
        this.email = email;
        this.roleId = roleId;
    }

    public User(String name, String login, String password, String email) {
        this.name = name;
        this.login = login;
        this.password = password;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        if (this.roleId != -1) {
            throw new IllegalArgumentException(String.format("The value can not be changed again. The current ID is: %d." , this.roleId));
        }
        this.roleId = roleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (roleId != user.roleId) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        if (login != null ? !login.equals(user.login) : user.login != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        return email != null ? email.equals(user.email) : user.email == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + roleId;
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", roleId=" + roleId +
                '}';
    }
}
