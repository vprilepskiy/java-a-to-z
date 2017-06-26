package ru.job4j.map.users;

import java.util.Calendar;

/**
 * Created by VLADIMIR on 26.06.2017.
 */
public class User {

    /**
     * Name.
     */
    private final String name;
    /**
     * Children.
     */
    private final int children;
    /**
     * Birthday.
     */
    private final Calendar birthday;

    /**
     * Constructor.
     * @param name - Name.
     * @param children - Children.
     * @param birthday - Birthday.
     */
    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    /**
     * Getter.
     * @return - Name.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Getter.
     * @return - Children.
     */
    public int getChildren() {
        return this.children;
    }

    /**
     * Getter.
     * @return - Birthday.
     */
    public Calendar getBirthday() {
        return this.birthday;
    }

}
