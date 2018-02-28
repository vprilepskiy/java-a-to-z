package ru.job4j.model.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by VLADIMIR on 28.02.2018.
 */
public class Options {

    private int id;
    private int description;
    private Set<VIN> vins = new HashSet<>();



    public Options() {
    }

    public Options(int description) {
        this.description = description;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDescription() {
        return description;
    }

    public void setDescription(int description) {
        this.description = description;
    }

    public Set<VIN> getVins() {
        return vins;
    }

    public void setVins(Set<VIN> vins) {
        this.vins = vins;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Options options = (Options) o;

        return description == options.description;
    }

    @Override
    public int hashCode() {
        return description;
    }


    @Override
    public String toString() {
        return "Options{" +
                "id=" + id +
                ", description=" + description +
                '}';
    }
}
