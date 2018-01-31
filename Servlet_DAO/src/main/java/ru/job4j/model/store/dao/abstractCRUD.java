package ru.job4j.model.store.dao;

import ru.job4j.model.entity.AbstractEntity;
import ru.job4j.model.store.DataBase;
import ru.job4j.model.store.Settings;

import java.util.List;

/**
 * Created by VLADIMIR on 30.01.2018.
 */
public abstract class abstractCRUD<T extends AbstractEntity> {

    /**
     * Data base.
     */
    final DataBase dataBase = DataBase.getInstance();

    /**
     * Settings.
     */
    final Settings settings = new Settings("store.properties");

    /**
     * Add entity in DB.
     * @param t - entity.
     * @return - index.
     */
    public abstract int create(T t);

    /**
     * Get all entities.
     * @return - entities.
     */
    public abstract List<T> read();

    /**
     * Get entity by id.
     * @param id - id.
     * @return - entity.
     */
    public abstract T readById(int id);

    /**
     * Update entity.
     * @param t - entity.
     * @return - true if updated.
     */
    public abstract boolean update(T t);

    /**
     * Delete entity.
     * @param id - id.
     * @return - true if deleted.
     */
    public abstract boolean delete(int id);

}
