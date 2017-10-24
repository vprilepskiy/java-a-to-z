package ru.job4j;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

/**
 * Created by VLADIMIR on 29.09.2017.
 */
public class DB {

    /**
     * Connection.
     */
    private Connection connection;


    /**
     * Set connection for DB.
     * @param url - URL.
     * @param username - Username.
     * @param password - Password.
     */
    public void setConnection(String url, String username, String password) {
        try {
            this.connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
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
    public class Manager {

        /**
         * Select.
         * @param sql - SQL.
         * @return - value.
         */
        public int select(String sql) {

            int result = 0;

            Statement st = null;
            ResultSet rs = null;

            try {
                st = connection.createStatement();
                rs = st.executeQuery(sql);

                if (rs.next()) {
                    result = rs.getInt(1);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                this.close(rs, st);
            }
            return result;
        }


        /**
         * Update.
         * @param sql - sql.
         * @return - value.
         */
        int update(String sql) {
            int updateRows = 0;
            Statement st = null;

            try {
                st = connection.createStatement();
                // выполняем запрос
                updateRows = st.executeUpdate(sql);

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                this.close(st);
            }
            return updateRows;
        }


        /**
         * Update.
         * @param prepareSQL - sql.
         * @param args - args.
         * @return - counter update rows.
         */
        int update(String prepareSQL, String[] args) {
            int updateRows = 0;
            PreparedStatement st = null;

            try {
                // передаем запрос
                st = connection.prepareStatement(prepareSQL);
                // передаем аргументы
                for (int i = 0; i < args.length; i++) {
                    st.setString(i + 1, args[i]);
                }
                // выполняем запрос
                updateRows = st.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                this.close(st);
            }
            return updateRows;
        }




        /**
         * Close resources.
         * @param st - Statement.
         */
        private void close(Statement st) {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }




        /**
         * Close resources.
         * @param rs - ResultSet.
         * @param st - Statement.
         */
        private void close(ResultSet rs, Statement st) {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            this.close(st);
        }
    }


}
