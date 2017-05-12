package ru.job4j.bank;

/**
 * Created by VLADIMIR on 11.05.2017.
 */
public class User {

    private String name;

    public String getName() {
        return name;
    }

    public int getPassport() {
        return passport;
    }

    private int passport;

    public User(String name, int passport) {
        this.name = name;
        this.passport = passport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return passport == user.passport;
    }

    @Override
    public int hashCode() {
        return passport;
    }
}
