package ru.job4j.model.store;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by VLADIMIR on 26.01.2018.
 */
public class DataBase {

    /**
     * Static class INSTANCE.
     */
    private static final DataBase INSTANCE = new DataBase();

    /**
     * Empty constructor.
     */
    private DataBase() {
    }

    /**
     * Getter.
     *
     * @return - Class INSTANCE
     */
    public static DataBase getInstance() {
        return INSTANCE;
    }


    /**
     * Connection.
     */
    private Connection connection;


    /**
     * Settings.
     */
    private final Settings settings = new Settings("store.properties");


    /**
     * Set connection for DB.
     *
     * @param url      - URL.
     * @param username - Username.
     * @param password - Password.
     */
    public void setConnection(String url, String username, String password) {
        final PoolProperties p = new PoolProperties();

        p.setUrl(url);
        p.setDriverClassName(settings.getValue("db_driver_name"));
        p.setUsername(username);
        p.setPassword(password);
        p.setJmxEnabled(true);
        p.setTestWhileIdle(false);
        p.setTestOnBorrow(true);
        p.setValidationQuery("SELECT 1");
        p.setTestOnReturn(false);
        p.setValidationInterval(30000);
        p.setTimeBetweenEvictionRunsMillis(30000);
        p.setMaxActive(100);
        p.setInitialSize(10);
        p.setMaxWait(10000);
        p.setRemoveAbandonedTimeout(60 * 60 * 24);
        p.setMinEvictableIdleTimeMillis(30000);
        p.setMinIdle(10);
        p.setLogAbandoned(true);
        p.setRemoveAbandoned(true);
        p.setJdbcInterceptors(String.format("%s%s", "org.apache.tomcat.jdbc.pool.interceptor.ConnectionState;", "org.apache.tomcat.jdbc.pool.interceptor.StatementFinalizer"));
        final DataSource datasource = new DataSource();
        datasource.setPoolProperties(p);

        if (this.connection == null) {
            try {
                this.connection = datasource.getConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * Close connection for DB.
     */
    public void closeConnection() {
        if (this.connection != null) {
            try {
                this.connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * Insert into table.
     * @param sql - prepare SQL.
     * @param args - args.
     * @return - primary key index.
     */
    public int create(String sql, Object[] args) {
        int id = -1;

        try (PreparedStatement st = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            // добавить аргументы
            for (int i = 0; i < args.length; i++) {
                st.setObject(i + 1, args[i]);
            }
            // выполнить вставку
            int rows = st.executeUpdate();

            if (rows != 0) {
                // запростиь сгенерированный primary key
                try (ResultSet rs = st.getGeneratedKeys()) {
                    if(rs.next()) {
                        id = rs.getInt(1);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return id;
    }


    /**
     * Get all rows.
     * @param sql - SQL.
     * @return - result set objects.
     */
    public List<List<Object>> read(String sql) {
        final List<List<Object>> rows = new LinkedList<>();

        try (Statement st = connection.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            // кол-во колонок
            int numberOfColumns = rs.getMetaData().getColumnCount();

            // получить все записи
            while (rs.next()) {
                final List<Object> row = new LinkedList<>();
                // получить одну строку
                for (int columnIndex = 1; columnIndex <= numberOfColumns; columnIndex++) {
                    final Object value = rs.getObject(columnIndex);
                    row.add(value);
                }
                rows.add(row);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rows;
    }


    /**
     * Get row by id.
     * @param sql - prepare SQL.
     * @param arg - arg.
     * @return - result set object.
     */
    public List<Object> readById(String sql, int arg) {

        final List<Object> row = new LinkedList<>();

        try (PreparedStatement st = connection.prepareStatement(sql)) {

            st.setInt(1, arg);

            try (ResultSet rs = st.executeQuery()) {
                // кол-во колонок
                int numberOfColumns = rs.getMetaData().getColumnCount();
                // если резульат запроса не пустой
                if (rs.next()) {
                    // выбрать все колонки
                    for (int columnIndex = 1; columnIndex <= numberOfColumns; columnIndex++) {
                        final Object value = rs.getObject(columnIndex);
                        row.add(value);
                    }
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return row;
    }


    /**
     * Update row.
     * @param sql - prepare SQL.
     * @param args - args.
     * @return - true if update.
     */
    public boolean update(String sql, Object[] args) {
        int rows = 0;

        try (PreparedStatement st = connection.prepareStatement(sql)) {
            // добавить аргументы
            for (int i = 0; i < args.length; i++) {
                st.setObject(i + 1, args[i]);
            }
            // выполнить
            rows = st.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return (rows != 0);
    }


    /**
     * Delete row.
     * @param sql - prepare SQL.
     * @param arg - args.
     * @return - true if delete.
     */
    public boolean delete(String sql, int arg) {
        int rows = 0;

        try (PreparedStatement st = connection.prepareStatement(sql)) {
            // добавить аргумент
            st.setInt(1, arg);
            // выполнить
            rows = st.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return (rows != 0);
    }

}

