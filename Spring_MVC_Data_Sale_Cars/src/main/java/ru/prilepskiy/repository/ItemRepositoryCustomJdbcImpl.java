package ru.prilepskiy.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.prilepskiy.config.PersistenceJPAConfig;
import ru.prilepskiy.entity.BodyTypesEntity;
import ru.prilepskiy.entity.ItemsEntity;
import ru.prilepskiy.entity.MarksEntity;
import ru.prilepskiy.entity.ModelsEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

@Repository
public class ItemRepositoryCustomJdbcImpl implements ItemRepositoryCustom {

    @Autowired
    private PersistenceJPAConfig jpaConfig;

    @Override
    public List<ItemsEntity> getItems(boolean today, boolean withPhoto, int markId, boolean active) {

        JdbcTemplate jdbcTemplate = this.jpaConfig.getJdbcTemplate();

        final String baseSql = "select i.id, mk.description as mark, md.description as model, b.description as body, i.year, i.price, i.photo, i.active, i.created " +
            "from items i " +
            "left join marks mk on i.mark_id = mk.id " +
            "left join models md on i.model_id = md.id " +
            "left join body_types b on i.body_type_id = b.id " +
            "where i.id is not null ";

        List<String> predicates = new LinkedList<>();
        // за сегодня
        if (today) {
            predicates.add("and i.created between TODAY() and NOW()");
        }
        // только с фото
        if (withPhoto) {
            predicates.add("and i.photo is not null");
        }
        // определенной марки
        if (markId != 0) {
            predicates.add("and i.mark_id = " + markId);
        }
        // только активные
        if (active) {
            predicates.add("and i.active = true");
        }

        StringBuilder sql = new StringBuilder(baseSql);
        predicates.forEach(predicate -> sql.append(predicate).append(" "));

        return jdbcTemplate.query(sql.toString(), this.mapper());
    }

    private RowMapper<ItemsEntity> mapper() {
        return new RowMapper<ItemsEntity>() {
            @Override
            public ItemsEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
                ItemsEntity item = new ItemsEntity();
                item.setId(rs.getInt("id"));
                item.setMark(new MarksEntity(rs.getString("mark")));
                item.setModel(new ModelsEntity(rs.getString("model")));
                item.setBodyType(new BodyTypesEntity(rs.getString("body")));
                item.setYear(rs.getInt("year"));
                item.setPrice(rs.getInt("price"));
                item.setPhoto(rs.getBytes("photo"));
                item.setActive(rs.getBoolean("active"));
                item.setCreated(rs.getTimestamp("created"));
                return item;
            }
        };
    }
}
