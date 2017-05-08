package ru.job4j.transformation;

/**
 * Created by VLADIMIR on 06.05.2017.
 */
public class User {

    /**
     * Номер.
     */
    private int id;

    /**
     * Имя.
     */
    private String name;

    /**
     * Город.
     */
    private String city;

    /**
     * Конструктор.
     * @param id - Номер.
     * @param name - Имя.
     * @param city - Город.
     */
    public User(int id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    /**
     * Getter.
     * @return - Номер.
     */
    public int getId() {
        return this.id;
    }

    @Override
    public boolean equals(Object o) {
        return o.hashCode() == this.id;
    }

    @Override
    public int hashCode() {
        return this.id;
    }
}
