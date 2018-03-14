package ru.job4j.model.entity;


/**
 * Created by VLADIMIR on 26.02.2018.
 */
public class Model {

    private int id;
    private String description;

    public Model() {
    }

    public Model(String description, Mark mark) {
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
