package ru.prilepskiy.model;

/**
 * Человек.
 */
public class PeopleEntity extends BaseEntity {

    /**
     * Имя.
     */
    private String firstName;

    /**
     * Отчество.
     */
    private String middleName;

    /**
     * Фамилия.
     */
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
