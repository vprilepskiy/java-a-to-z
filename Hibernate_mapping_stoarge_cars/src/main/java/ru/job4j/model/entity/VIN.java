package ru.job4j.model.entity;

import java.io.Serializable;

/**
 * Created by VLADIMIR on 19.02.2018.
 */
public class VIN {

    private int id;
    private String number;
    private Car car;



    public VIN(String number) {
        this.number = number;
    }

    public VIN() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VIN vin = (VIN) o;

        return number != null ? number.equals(vin.number) : vin.number == null;
    }

    @Override
    public int hashCode() {
        return number != null ? number.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "VIN{" +
                "id=" + id +
                ", number='" + number + '\'' +
                '}';
    }
}



