package ru.job4j.model.store.defaultData;

import ru.job4j.model.entity.BodyType;


/**
 * Created by VLADIMIR on 12.03.2018.
 */
public enum BodyTypes {

    SEDAN,
    HATCHBACK,
    UNIVERSAL,
    MINIVAN,
    PICKUP;


    private BodyType bodyType;


    BodyTypes() {
        this.bodyType = new BodyType(this.name());
    }


    public BodyType getBodyType() {
        return this.bodyType;
    }


}
