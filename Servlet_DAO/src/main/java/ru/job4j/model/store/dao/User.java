package ru.job4j.model.store.dao;


import java.util.LinkedList;
import java.util.List;

/**
 * Created by VLADIMIR on 30.01.2018.
 */
public class User extends abstractCRUD<ru.job4j.model.entity.User> {


    @Override
    public int create(ru.job4j.model.entity.User user) {
        final String sql = settings.getValue("SQL_INSERT_TABLE_USERS");
        final Object[] args = new Object[]{user.getName(), user.getLogin(), user.getPassword(), user.getEmail(), user.getRoleId()};
        final int id = this.dataBase.create(sql, args);
        user.setId(id);
        return id;
    }

    @Override
    public List<ru.job4j.model.entity.User> read() {
        final List<ru.job4j.model.entity.User> users = new LinkedList<>();

        final List<List<Object>> rows = this.dataBase.read(settings.getValue("SQL_SELECT_TABLE_USERS"));

        for (List<Object> row : rows) {
            final int id = (int) row.get(0);
            final String name = (String) row.get(1);
            final String login = (String) row.get(2);
            final String password = (String) row.get(3);
            final String email = (String) row.get(4);
            final int roleId = (int) row.get(5);

            users.add(new ru.job4j.model.entity.User(id, name, login, password, email, roleId));
        }

        return users;
    }

    @Override
    public ru.job4j.model.entity.User readById(int id) {
        final List<Object> row = this.dataBase.readById(settings.getValue("SQL_SELECT_TABLE_USERS_BY_ID"), id);

        if (!row.isEmpty()) {
            final int getId = (int) row.get(0);
            final String name = (String) row.get(1);
            final String login = (String) row.get(2);
            final String password = (String) row.get(3);
            final String email = (String) row.get(4);
            final int roleId = (int) row.get(5);

            return new ru.job4j.model.entity.User(id, name, login, password, email, roleId);
        }

        return null;
    }

    @Override
    public boolean update(ru.job4j.model.entity.User user) {
        final Object[] args = new Object[]{user.getName(), user.getLogin(), user.getPassword(), user.getEmail(), user.getRoleId(), user.getId()};
        return this.dataBase.update(settings.getValue("SQL_UPDATE_TABLE_USERS"), args);
    }

    @Override
    public boolean delete(int id) {
        return this.dataBase.delete(settings.getValue("SQL_DELETE_TABLE_USERS"), id);
    }
}


