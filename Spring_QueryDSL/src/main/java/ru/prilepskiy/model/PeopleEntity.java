package ru.prilepskiy.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * Человек.
 */
@MappedSuperclass
public class PeopleEntity extends BaseEntity {

    /**
     * Имя.
     */
    @Column
    private String firstName;

    /**
     * Отчество.
     */
    @Column
    private String middleName;

    /**
     * Фамилия.
     */
    @Column
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
