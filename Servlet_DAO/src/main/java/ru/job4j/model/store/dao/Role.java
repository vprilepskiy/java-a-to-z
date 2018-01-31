package ru.job4j.model.store.dao;

import ru.job4j.model.store.DataBase;
import ru.job4j.model.store.Settings;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by VLADIMIR on 30.01.2018.
 */
public class Role extends abstractCRUD<ru.job4j.model.entity.Role> {

    @Override
    public int create(ru.job4j.model.entity.Role role) {
        final String sql = settings.getValue("SQL_INSERT_TABLE_ROLES");
        final Object[] args = new Object[]{role.getName()};
        final int id = this.dataBase.create(sql, args);
        role.setId(id);
        return id;
    }

    @Override
    public List<ru.job4j.model.entity.Role> read() {

        final List<ru.job4j.model.entity.Role> roles = new LinkedList<>();

        final List<List<Object>> rows = this.dataBase.read(settings.getValue("SQL_SELECT_TABLE_ROLES"));

        for (List<Object> row : rows) {
            final int id = (int) row.get(0);
            final String name = (String) row.get(1);

            roles.add(new ru.job4j.model.entity.Role(id, name));
        }

        return roles;
    }

    @Override
    public ru.job4j.model.entity.Role readById(int id) {
        final List<Object> row = this.dataBase.readById(settings.getValue("SQL_SELECT_TABLE_ROLES_BY_ID"), id);

        if (!row.isEmpty()) {
            final int getId = (int) row.get(0);
            final String name = (String) row.get(1);

            return new ru.job4j.model.entity.Role(getId, name);
        }

        return null;
    }

    @Override
    public boolean update(ru.job4j.model.entity.Role role) {
        final Object[] args = new Object[]{role.getName(), role.getId()};
        return this.dataBase.update(settings.getValue("SQL_UPDATE_TABLE_ROLES"), args);
    }

    @Override
    public boolean delete(int id) {
        return this.dataBase.delete(settings.getValue("SQL_DELETE_TABLE_ROLES"), id);
    }
}
