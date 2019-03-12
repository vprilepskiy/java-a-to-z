package ru.prilepskiy.repository.defaultData;

import ru.prilepskiy.entity.BodyTypesEntity;

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
