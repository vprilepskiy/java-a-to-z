package ru.job4j.model.entity;

import java.sql.Timestamp;

/**
 * Created by VLADIMIR on 13.02.2018.
 */
public class Item {

    /**
     * Id.
     */
    private int id;

    /**
     * Description.
     */
    private String desc;

    /**
     * Create date.
     */
    private Timestamp created;

    /**
     * Done.
     */
    private boolean done;

    /**
     * Constructor.
     * @param id
     * @param desc
     * @param created
     * @param done
     */
    public Item(int id, String desc, Timestamp created, boolean done) {
        this.id = id;
        this.desc = desc;
        this.created = created;
        this.done = done;
    }

    /**
     * Empty constructor.
     * Hibernate used reflection.
     */
    public Item() {
    }


    /**
     * Getter.
     * @return - id.
     */
    public int getId() {
        return id;
    }

    /**
     * Setter.
     * @param id - id.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter.
     * @return - description.
     */
    public String getDesc() {
        return desc;
    }

    /**
     * Setter.
     * @param desc - description.
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * Getter.
     * @return - create date.
     */
    public Timestamp getCreated() {
        return created;
    }

    /**
     * Setter.
     * @param created - create date.
     */
    public void setCreated(Timestamp created) {
        this.created = created;
    }

    /**
     * Getter.
     * @return - done.
     */
    public boolean isDone() {
        return done;
    }

    /**
     * Setter.
     * @param done - done.
     */
    public void setDone(boolean done) {
        this.done = done;
    }


    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", desc='" + desc + '\'' +
                ", created=" + created +
                ", done=" + done +
                '}';
    }
}
