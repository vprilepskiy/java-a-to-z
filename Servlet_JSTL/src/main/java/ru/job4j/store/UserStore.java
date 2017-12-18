package ru.job4j.store;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;
import ru.job4j.Settings;
import ru.job4j.models.Role;
import ru.job4j.models.User;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by VLADIMIR on 22.11.2017.
 * <p>
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
     * Get all users.
     *
     * @return - users.
     */
    public List<User> get() {
        final List<User> users = new LinkedList<>();

        try (Statement st = connection.createStatement();
             ResultSet rs = st.executeQuery(settings.getValue("SQL_SELECT_ALL_USERS"))) {

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
     * Get user by name.
     *
     * @return - user.
     */
    public User getByName(User user) {

        User result = null;

        try (PreparedStatement st = connection.prepareStatement(settings.getValue("SQL_SELECT_USER"))) {
            st.setString(1, user.getName());
            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    final String name = rs.getString("name");
                    final String login = rs.getString("login");
                    final String password = rs.getString("password");
                    final String email = rs.getString("email");
                    final String createDate = rs.getString("create_date");
                    final Role role = this.getRoleByLoginPass(login, password);

                    result = new User(name, login, password, email, createDate, role);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }


    /**
     * Update witch prepare arguments.
     *
     * @param prepareSQL - SQL.
     * @param args       - arguments.
     * @return - number rows.
     */
    private int editUser(String prepareSQL, String[] args) {

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


    /**
     * Add user.
     *
     * @param user - user.
     * @return - number of added users
     */
    public int add(User user) {
        final String prepareSQL = settings.getValue("SQL_INSERT_USER");
        final String[] args = {user.getName(), user.getLogin(), user.getPassword(), user.getEmail(), user.getRole().getDescription(), user.getName()};
        return this.editUser(prepareSQL, args);
    }


    /**
     * Edit user (Login, Email) by Name.
     *
     * @param user - user.
     * @return - number of edited users.
     */
    public int edit(User user) {
        final String prepareSQL = settings.getValue("SQL_UPDATE_USER");
        final String[] args = {user.getLogin(), user.getPassword(), user.getEmail(), user.getRole().getDescription(), user.getName()};
        return this.editUser(prepareSQL, args);
    }


    /**
     * Delete user by Name.
     *
     * @param user - user.
     * @return - number of remote users.
     */
    public int delete(User user) {
        final String prepareSQL = settings.getValue("SQL_DELETE_USER");
        final String[] args = {user.getName()};
        return this.editUser(prepareSQL, args);
    }


    /**
     * Check user by login and password.
     *
     * @param login    - login.
     * @param password - password.
     * @return - True, if there is.
     */
    public boolean isCredentional(String login, String password) {

        boolean result = false;

        try (PreparedStatement st = connection.prepareStatement(settings.getValue("SQL_SELECT_USER_VALID_BY_LOGIN_PASS"))) {
            st.setString(1, login);
            st.setString(2, password);

            try (ResultSet rs = st.executeQuery()) {
                result = rs.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }


    /**
     * Get user by login and password.
     * @param login - login.
     * @param password - password.
     * @return - user.
     */
    public User getByLoginPass(String login, String password) {

        User result = null;

        try (PreparedStatement st = connection.prepareStatement(settings.getValue("SQL_SELECT_USER_VALID_BY_LOGIN_PASS"))) {
            st.setString(1, login);
            st.setString(2, password);
            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    final String name = rs.getString("name");
                    final String createDate = rs.getString("create_date");
                    final String email = rs.getString("email");
                    final Role role = this.getRoleByLoginPass(login, password);
                    result = new User(name, login, password, email, createDate, role);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }


    /**
     * Get role by login and password.
     * @param login - login.
     * @param password - password.
     * @return - role.
     */
    private Role getRoleByLoginPass(String login, String password) {

        Role role = null;

        try (PreparedStatement stRole = connection.prepareStatement(settings.getValue("SQL_SELECT_ROLE_BY_LOGIN_PASS"));
             PreparedStatement stRights = connection.prepareStatement(settings.getValue("SQL_SELECT_RIGHTS_BY_LOGIN_PASS"))) {

            stRole.setString(1, login);
            stRole.setString(2, password);

            stRights.setString(1, login);
            stRights.setString(2, password);

            try (ResultSet rsRole = stRole.executeQuery();
                 ResultSet rsRights = stRights.executeQuery()) {
                if (rsRole.next()) {
                    final String roleName = rsRole.getString("role");
                    role = new Role(roleName);
                }

                while (rsRights.next()) {
                    final String right = rsRights.getString("description");
                    role.addRight(right);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return role;
    }


    /**
     * Get all roles.
     * @return - roles.
     */
    public List<Role> getRoles() {

        final List<Role> roles = new LinkedList<>();

        try (Statement st = connection.createStatement();
             ResultSet rs = st.executeQuery(settings.getValue("SQL_SELECT_ROLE"))) {

            while (rs.next()) {
                final String role = rs.getString("role");
                roles.add(new Role(role));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return roles;
    }

}
