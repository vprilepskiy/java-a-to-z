package ru.job4j.model.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by VLADIMIR on 19.02.2018.
 */
public class VIN {

    private int id;
    private String number;
    private Car car;
    private SalesOrder salesOrder;
    private Set<Options> options = new HashSet<>();


    public VIN(String number, Car car, SalesOrder salesOrder) {
        this.number = number;
        this.car = car;
        this.salesOrder = salesOrder;
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

    public SalesOrder getSalesOrder() {
        return salesOrder;
    }

    public void setSalesOrder(SalesOrder salesOrder) {
        this.salesOrder = salesOrder;
    }

    public Set<Options> getOptions() {
        return options;
    }

    public void setOptions(Set<Options> options) {
        this.options = options;
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



