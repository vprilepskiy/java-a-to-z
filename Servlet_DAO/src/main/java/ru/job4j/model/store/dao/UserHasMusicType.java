package ru.job4j.model.store.dao;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by VLADIMIR on 30.01.2018.
 */
public class UserHasMusicType extends abstractCRUD<ru.job4j.model.entity.UserHasMusicType> {

    @Override
    public int create(ru.job4j.model.entity.UserHasMusicType userHasMusicType) {
        final String sql = settings.getValue("SQL_INSERT_TABLE_USERS_HAS_MUSIC_TYPES");
        final Object[] args = new Object[]{userHasMusicType.getUserId(), userHasMusicType.getMusicTypeId()};
        final int id = this.dataBase.create(sql, args);
        userHasMusicType.setId(id);
        return id;
    }

    @Override
    public List<ru.job4j.model.entity.UserHasMusicType> read() {
        final List<ru.job4j.model.entity.UserHasMusicType> userHasMusicTypes = new LinkedList<>();

        final List<List<Object>> rows = this.dataBase.read(settings.getValue("SQL_SELECT_TABLE_USERS_HAS_MUSIC_TYPES"));

        for (List<Object> row : rows) {
            final int id = (int) row.get(0);
            final int userId = (int) row.get(1);
            final int musicTypeId = (int) row.get(2);

            userHasMusicTypes.add(new ru.job4j.model.entity.UserHasMusicType(id, userId, musicTypeId));
        }

        return userHasMusicTypes;
    }

    @Override
    public ru.job4j.model.entity.UserHasMusicType readById(int id) {
        final List<Object> row = this.dataBase.readById(settings.getValue("SQL_SELECT_TABLE_USERS_HAS_MUSIC_TYPES_BY_ID"), id);

        if (!row.isEmpty()) {
            final int getId = (int) row.get(0);
            final int userId = (int) row.get(1);
            final int musicTypeId = (int) row.get(2);

            return new ru.job4j.model.entity.UserHasMusicType(id, userId, musicTypeId);
        }

        return null;
    }

    @Override
    public boolean update(ru.job4j.model.entity.UserHasMusicType userHasMusicType) {
        final Object[] args = new Object[]{userHasMusicType.getUserId(), userHasMusicType.getMusicTypeId(), userHasMusicType.getId()};
        return this.dataBase.update(settings.getValue("SQL_UPDATE_TABLE_USERS_HAS_MUSIC_TYPES"), args);
    }

    @Override
    public boolean delete(int id) {
        return this.dataBase.delete(settings.getValue("SQL_DELETE_TABLE_USERS_HAS_MUSIC_TYPES"), id);
    }
}
