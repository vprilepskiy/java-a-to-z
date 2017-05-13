package ru.job4j.bank;

/**
 * Created by VLADIMIR on 11.05.2017.
 */
public class User {

    /**
     * Имя.
     */
    private String name;

    /**
     * Номер паспорта.
     */
    private int passport;

    /**
     * Пользователь.
     * @param name - Имя.
     * @param passport - Номер паспорта.
     */
    public User(String name, int passport) {
        this.name = name;
        this.passport = passport;
    }

    /**
     * Пользователь.
     * @param passport - Номер паспорта.
     */
    public User(int passport) {
        this.passport = passport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        User user = (User) o;

        return passport == user.passport;
    }

    @Override
    public int hashCode() {
        return passport;
    }
}
