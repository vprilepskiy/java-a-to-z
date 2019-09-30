package ru.prilepskiy.model;

import javax.persistence.Entity;

/**
 * Школа.
 */
@Entity
public class SchoolEntity extends BaseEntity {

    /**
     * Номер.
     */
    private Integer number;

    /**
     * Название.
     */
    private String name;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
