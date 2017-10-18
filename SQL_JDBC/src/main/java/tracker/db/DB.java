package tracker.db;

import tracker.models.Item;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by VLADIMIR on 17.10.2017.
 */
public class DB extends jdbc.db.DB {

    /**
     * Manager for DB.
     */
    public class Manager extends jdbc.db.DB.Manager {

        /**
         * Update.
         * @param prepareSQL - query.
         * @param arg - arg.
         * @return - count updates.
         */
        public int update(String prepareSQL, Object arg) {
            return this.update(prepareSQL, new Object[]{arg});
        }


        /**
         * Update.
         * @param prepareSQL - query.
         * @param args - args.
         * @return - count updates.
         */
        public int update(String prepareSQL, Object[] args) {
            int updateRows = 0;
            PreparedStatement st = null;

            try {
                // передаем запрос
                st = super.getConnection().prepareStatement(prepareSQL);
                // передаем аргументы
                for (int i = 0; i < args.length; i++) {
                    st.setObject(i + 1, args[i]);
                }
                // выполняем запрос
                updateRows = st.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                super.close(st);
            }
            return updateRows;
        }


        /**
         * Select rows.
         * @param prepareSQL - Query.
         * @param arg - arg.
         * @return - Items.
         */
        public List<Item> getItems(String prepareSQL, Object arg) {

            List<Item> rows = new ArrayList<>();

            PreparedStatement st = null;
            ResultSet rs = null;

            try {
                // передаем запрос
                st = super.getConnection().prepareStatement(prepareSQL);

                // передаем аргумент
                st.setObject(1, arg);

                // выполняем запрос
                rs = st.executeQuery();

                // забераем результаты
                while (rs.next()) {
                    final int id = rs.getInt(1);
                    final String name = rs.getString(2);
                    final String desc = rs.getString(3);
                    final long create = rs.getLong(4);

                    Item item = new Item(name, desc, create);
                    item.setId(id);
                    rows.add(item);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                super.close(rs, st);
            }
            return rows;
        }


        /**
         * Select rows.
         * @param sql - Query.
         * @return - Items.
         */
        public List<Item> getItems(String sql) {

            List<Item> rows = new ArrayList<>();

            Statement st = null;
            ResultSet rs = null;

            try {
                st = super.getConnection().createStatement();
                rs = st.executeQuery(sql);

                while (rs.next()) {
                    final int id = rs.getInt(1);
                    final String name = rs.getString(2);
                    final String desc = rs.getString(3);
                    final long create = rs.getLong(4);

                    Item item = new Item(name, desc, create);
                    item.setId(id);
                    rows.add(item);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                super.close(rs, st);
            }
            return rows;
        }


        /**
         * Select.
         * @param prepareSQL - Query.
         * @param arg - arg.
         * @return - rows.
         */
        public List<List<Object>> getSelect(String prepareSQL, Object arg) {
            return this.getSelect(prepareSQL, new Object[] {arg});
        }


        /**
         * Select.
         * @param prepareSQL - Query.
         * @param args - args.
         * @return - rows.
         */
        public List<List<Object>> getSelect(String prepareSQL, Object[] args) {

            List<List<Object>> rows = new ArrayList<>();

            PreparedStatement st = null;
            ResultSet rs = null;

            try {
                st = super.getConnection().prepareStatement(prepareSQL);

                for (int i = 0; i < args.length; i++) {
                    st.setObject(i + 1, args[i]);
                }

                rs = st.executeQuery();
                ResultSetMetaData md = rs.getMetaData();
                int columnCount = md.getColumnCount();

                while (rs.next()) {
                    // получить строку
                    List<Object> row = new ArrayList<>();
                    for (int i = 1; i <= columnCount; i++) {
                        row.add(rs.getObject(i));
                    }
                    // добавить строку
                    rows.add(row);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                super.close(rs, st);
            }
            return rows;
        }
    }



}
