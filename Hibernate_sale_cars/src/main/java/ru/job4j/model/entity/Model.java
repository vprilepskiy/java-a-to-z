package ru.job4j.model.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by VLADIMIR on 26.02.2018.
 */
public class Model {

    private int id;

    private String description;

    private Set<Item> items = new HashSet<>();



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

    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }


    @Override
    public String toString() {
        return "BodyType{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}
