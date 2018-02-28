package ru.job4j.model.entity;

/**
 * Created by VLADIMIR on 19.02.2018.
 */
public class SalesOrder {

    private int id;
    private double price;


    public SalesOrder() {
    }

    public SalesOrder(double price) {
        this.price = price;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SalesOrder order = (SalesOrder) o;

        return Double.compare(order.price, price) == 0;
    }

    @Override
    public int hashCode() {
        long temp = Double.doubleToLongBits(price);
        return (int) (temp ^ (temp >>> 32));
    }


    @Override
    public String toString() {
        return "SalesOrder{" +
                "id=" + id +
                ", price=" + price +
                '}';
    }
}

