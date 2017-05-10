package ru.job4j.sorting;

/**
 * Created by VLADIMIR on 08.05.2017.
 */
public class User implements Comparable<User> {

    /**
     * Имя.
     */
    private String name;

    /**
     * Возраст.
     */
    private int age;

    /**
     * Constructor.
     * @param name - Имя.
     * @param age - Возраст.
     */
    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * Getter.
     * @return - name.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Сортировка по возрасту.
     * @param o - User.
     * @return - 1 если сравниваемый user моложе этого, -1 если старше, 0 если ровестники.
     */
    @Override
    public int compareTo(User o) {
        return Integer.compare(this.age, o.age);
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

        return name != null ? name.equals(user.name) : user.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
