package ru.job4j.model.store.dao;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by VLADIMIR on 26.01.2018.
 */
public class Address extends abstractCRUD<ru.job4j.model.entity.Address> {


    @Override
    public int create(ru.job4j.model.entity.Address address) {
        final String sql = settings.getValue("SQL_INSERT_TABLE_ADDRESSES");
        final Object[] args = new Object[]{address.getPlace(), address.getUserId()};
        final int id = this.dataBase.create(sql, args);
        address.setId(id);
        return id;
    }


    @Override
    public List<ru.job4j.model.entity.Address> read() {

        final List<ru.job4j.model.entity.Address> addresses = new LinkedList<>();

        final List<List<Object>> rows = this.dataBase.read(settings.getValue("SQL_SELECT_TABLE_ADDRESSES"));

        for (List<Object> row : rows) {
            final int id = (int) row.get(0);
            final String place = (String) row.get(1);
            final int userId = (int) row.get(2);

            addresses.add(new ru.job4j.model.entity.Address(id, place, userId));
        }

        return addresses;
    }


    @Override
    public ru.job4j.model.entity.Address readById(int id) {
        final List<Object> row = this.dataBase.readById(settings.getValue("SQL_SELECT_TABLE_ADDRESSES_BY_ID"), id);

        if (!row.isEmpty()) {
            final int getId = (int) row.get(0);
            final String place = (String) row.get(1);
            final int userId = (int) row.get(2);

            return new ru.job4j.model.entity.Address(getId, place, userId);
        }

        return null;
    }


    @Override
    public boolean update(ru.job4j.model.entity.Address address) {
        final Object[] args = new Object[]{address.getPlace(), address.getUserId(), address.getId()};
        return this.dataBase.update(settings.getValue("SQL_UPDATE_TABLE_ADDRESSES"), args);
    }


    @Override
    public boolean delete(int id) {
        return this.dataBase.delete(settings.getValue("SQL_DELETE_TABLE_ADDRESSES"), id);
    }
}
