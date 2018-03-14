package ru.job4j.model.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by VLADIMIR on 26.02.2018.
 */
public class Mark {

    private int id;
    private String description;
    private Set<Model> models = new HashSet<>();

    public Mark() {
    }

    public Mark(String description) {
        this.description = description;
    }

    public Mark(String description, Set<Model> models) {
        this.description = description;
        this.models = models;
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

    public Set<Model> getModels() {
        return models;
    }

    public void setModels(Set<Model> models) {
        this.models = models;
    }

    @Override
    public String toString() {
        return "BodyType{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}
