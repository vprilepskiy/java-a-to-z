package ru.prilepskiy.repository.defaultData;

import ru.prilepskiy.domain.BodyTypesEntity;


/**
 * Created by VLADIMIR on 12.03.2018.
 */
public enum BodyTypes {

    SEDAN,
    HATCHBACK,
    UNIVERSAL,
    MINIVAN,
    PICKUP;

    private BodyTypesEntity bodyType;

    BodyTypes() {
        this.bodyType = new BodyTypesEntity(this.name());
    }

    public BodyTypesEntity getBodyType() {
        return this.bodyType;
    }
}
