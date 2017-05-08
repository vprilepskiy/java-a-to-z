package ru.job4j.sorting;

/**
 * Created by VLADIMIR on 08.05.2017.
 */
public class User implements Comparable<User> {

    private String name;

    private int age;

    public User (String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * Сортировка по возрасту.
     * @param o
     * @return
     */
    @Override
    public int compareTo(User o) {
        if (this.age > o.age) {
            return -1;
        } else if (this.age < o.age) {
            return 1;
        } else {
            return 0;
        }
    }



}
