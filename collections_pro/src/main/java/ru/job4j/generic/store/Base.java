package ru.job4j.generic.store;

/**
 * Created by VLADIMIR on 30.05.2017.
 */
public abstract class Base {

    /**
     * id.
     */
    private String id;

    /**
     * Constructor.
     * @param id - id.
     */
    public Base(String id) {
        this.id = id;
    }

    /**
     * Getter.
     * @return - id.
     */
    public String getId() {
        return this.id;
    }

    /**
     * Setter.
     * @param id - id.
     */
    public void setId(String id) {
        this.id = id;
    }


    /**
     * Override Equals and HashCode for id.
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Base base = (Base) o;

        return id != null ? id.equals(base.id) : base.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
