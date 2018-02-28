package ru.job4j.model.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by VLADIMIR on 19.02.2018.
 */
public class Car {

    private int id;
    private String mark;
    private String model;
    private Set<VIN> vins = new HashSet<>();


    public Car(String mark, String model) {
        this.mark = mark;
        this.model = model;
    }

    public Car() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
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

        Car car = (Car) o;

        if (mark != null ? !mark.equals(car.mark) : car.mark != null) return false;
        return model != null ? model.equals(car.model) : car.model == null;
    }

    @Override
    public int hashCode() {
        int result = mark != null ? mark.hashCode() : 0;
        result = 31 * result + (model != null ? model.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", mark='" + mark + '\'' +
                ", model='" + model + '\'' +
                '}';
    }


}
