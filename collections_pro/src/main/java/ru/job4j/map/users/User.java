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


    @Override
    public String toString() {
        return "User{name='" + name + '\'' + ", children=" + children + ", birthday=" + birthday.getTimeInMillis() + '}';
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

        if (children != user.children) {
            return false;
        }
        if (name != null ? !name.equals(user.name) : user.name != null) {
            return false;
        }
        return birthday != null ? birthday.equals(user.birthday) : user.birthday == null;
    }

    @Override
    public int hashCode() {
        final int optimalNaturalNumber = 31;
        int result = name != null ? name.hashCode() : 0;
        result = optimalNaturalNumber * result + children;
        result = optimalNaturalNumber * result + (birthday != null ? birthday.hashCode() : 0);
        return result;
    }
}
