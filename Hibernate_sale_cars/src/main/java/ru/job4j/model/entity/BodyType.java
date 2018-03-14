package ru.job4j.model.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by VLADIMIR on 26.02.2018.
 */
public class BodyType {

    private int id;
    private String description;


    public BodyType() {
    }

    public BodyType(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Override
    public String toString() {
        return "BodyType{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}
