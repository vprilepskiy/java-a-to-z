package ru.job4j.store;

import ru.job4j.Settings;
import ru.job4j.models.User;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by VLADIMIR on 22.11.2017.
 *
 * SINGLETON. Eager initialization.
 */
public class UserStore {


    /**
     * Static class INSTANCE.
     */
    private static final UserStore INSTANCE = new UserStore();

    /**
     * Empty constructor.
     */
    private UserStore() {
    }

    /**
     * Getter.
     *
     * @return - Class INSTANCE
     */
    public static UserStore getInstance() {
        return INSTANCE;
    }


    /**
     * Connection.
     */
    private Connection connection;


    /**
     * Set connection for DB.
     *
     * @param url      - URL.
     * @param username - Username.
     * @param password - Password.
     */
    public void setConnection(String url, String username, String password) {
        try {
            Class.forName("org.postgresql.Driver");

            if (this.connection == null) {
                this.connection = DriverManager.getConnection(url, username, password);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
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
     * Manager for DB.
     */
    private class Manager {

        /**
         * Select.
         * @param sql - sql.
         * @return
         */
        public List<User> getUsers(String sql) {
            final List<User> users = new LinkedList<>();

            try (ResultSet rs = connection.createStatement().executeQuery(sql)) {
                while (rs.next()) {
                    final String name = rs.getString("name");
                    final String login = rs.getString("login");
                    final String email = rs.getString("email");
                    final String createDate = rs.getString("create_date");
                    users.add(new User(name, login, email, createDate));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return users;
        }


        /**
         * Update witch prepare arguments.
         * @param prepareSQL - SQL.
         * @param args - arguments.
         * @return - number rows.
         */
        public int editUser(String prepareSQL, String[] args) {

            int updateRows = 0;

            try (PreparedStatement st = connection.prepareStatement(prepareSQL)) {
                for (int i = 0; i < args.length; i++) {
                    st.setString(i + 1, args[i]);
                }

                updateRows = st.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return updateRows;
        }
    }


    /**
     * Settings.
     */
    private final Settings settings = new Settings("store.properties");

    /**
     * Manager.
     */
    private final Manager dbManager = new Manager();


    /**
     * Get all users.
     * @return - users.
     */
    public List<User> get() {
        return this.dbManager.getUsers(settings.getValue("SQL_SELECT_ALL_USERS"));
    }


    /**
     * Add user.
     * @param user - user.
     * @return - number of added users
     */
    public int add(User user) {
        final String prepareSQL = settings.getValue("SQL_INSERT_USER");
        final String[] args = {user.getName(), user.getLogin(), user.getEmail(), user.getName()};
        return this.dbManager.editUser(prepareSQL, args);
    }


    /**
     * Edit user.
     * @param user - user.
     * @return - number of edited users.
     */
    public int edit(User user) {
        final String prepareSQL = settings.getValue("SQL_UPDATE_USER");
        final String[] args = {user.getLogin(), user.getEmail(), user.getName()};
        return this.dbManager.editUser(prepareSQL, args);
    }


    /**
     * Delete user.
     * @param user - user.
     * @return - number of remote users.
     */
    public int delete(User user) {
        final String prepareSQL = settings.getValue("SQL_DELETE_USER");
        final String[] args = {user.getName()};
        return this.dbManager.editUser(prepareSQL, args);
    }

}
