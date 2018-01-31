package ru.job4j.model.entity;

/**
 * Created by VLADIMIR on 30.01.2018.
 */
public abstract class AbstractEntity {

    /**
     * Id.
     */
    int id = -1;

    /**
     * Setter.
     * @param id - id.
     * @throws IllegalArgumentException - Will fall when the value is changed again.
     */
    public void setId(int id) {
        if (this.id != -1) {
            throw new IllegalArgumentException(String.format("The value can not be changed again. The current ID is: %d.", this.id));
        }
        this.id = id;
    }

    /**
     * Getter.
     * @return - id.
     */
    public int getId() {
        return this.id;
    }
}
