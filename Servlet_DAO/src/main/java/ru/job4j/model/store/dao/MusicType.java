package ru.job4j.model.store.dao;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by VLADIMIR on 29.01.2018.
 */
public class MusicType extends abstractCRUD<ru.job4j.model.entity.MusicType> {

    @Override
    public int create(ru.job4j.model.entity.MusicType musicType) {
        final String sql = settings.getValue("SQL_INSERT_TABLE_MUSIC_TYPES");
        final Object[] args = new Object[]{musicType.getName()};
        final int id = this.dataBase.create(sql, args);
        musicType.setId(id);
        return id;
    }


    @Override
    public List<ru.job4j.model.entity.MusicType> read() {

        final List<ru.job4j.model.entity.MusicType> musicTypes = new LinkedList<>();

        final List<List<Object>> rows = this.dataBase.read(settings.getValue("SQL_SELECT_TABLE_MUSIC_TYPES"));

        for (List<Object> row : rows) {
            final int id = (int) row.get(0);
            final String name = (String) row.get(1);

            musicTypes.add(new ru.job4j.model.entity.MusicType(id, name));
        }

        return musicTypes;
    }


    @Override
    public ru.job4j.model.entity.MusicType readById(int id) {
        final List<Object> row = this.dataBase.readById(settings.getValue("SQL_SELECT_TABLE_MUSIC_TYPES_BY_ID"), id);

        if (!row.isEmpty()) {
            final int getId = (int) row.get(0);
            final String name = (String) row.get(1);

            return new ru.job4j.model.entity.MusicType(getId, name);
        }

        return null;
    }


    @Override
    public boolean update(ru.job4j.model.entity.MusicType musicType) {
        final Object[] args = new Object[]{musicType.getName(), musicType.getId()};
        return this.dataBase.update(settings.getValue("SQL_UPDATE_TABLE_MUSIC_TYPES"), args);
    }


    @Override
    public boolean delete(int id) {
        return this.dataBase.delete(settings.getValue("SQL_DELETE_TABLE_MUSIC_TYPES"), id);
    }
}
