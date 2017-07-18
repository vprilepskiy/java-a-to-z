package ru.job4j.example;

/**
 * Created by VLADIMIR on 18.07.2017.
 */
public class User {

    /**
     * Id.
     */
    private final int id;
    /**
     * Name.
     */
    private final String name;
    /**
     * First name.
     */
    private final String firstName;
    /**
     * Moment.
     */
    private final long createRow;

    /**
     * Constructor.
     * @param id - Id.
     * @param name - Name.
     * @param firstName - First name.
     */
    public User(int id, String name, String firstName) {
        this.id = id;
        this.name = name;
        this.firstName = firstName;
        this.createRow = System.currentTimeMillis();
    }

    @Override
    public boolean equals(Object o) {
        // если ссылка на объект одинаковая то true
        if (this == o) {
            return true;
        }

        // если нулевая ссылка на сравниваемый объект то false
        // если классы родители разные то false
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        // cast to User
        User user = (User) o;

        // проверка полей класса (бизнес логики)
        if (id != user.id) {
            return false;
        }
        if (name != null ? !name.equals(user.name) : user.name != null) {
            return false;
        }
        return firstName != null ? firstName.equals(user.firstName) : user.firstName == null;
    }

    @Override
    public int hashCode() {
        int result = 0;
        final int simpleNumber = 31;
        result = simpleNumber * result + id;
        result = simpleNumber * result + (name != null ? name.hashCode() : 0);
        result = simpleNumber * result + (firstName != null ? firstName.hashCode() : 0);
        return result;
    }
}
