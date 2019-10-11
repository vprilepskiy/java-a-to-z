package ru.prilepskiy.dto;

import java.io.Serializable;

public abstract class BaseDto implements Serializable {

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
