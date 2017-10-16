package jdbc.db;

import jdbc.xml.Entry;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

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
         * Select rows.
         * @param sql - SQL.
         * @return - Entries.
         */
        public List<Entry> getRows(String sql) {
            return this.getRows(sql, 0);
        }


        /**
         * Select rows.
         * @param sql - SQL.
         * @param maxRows - Limit the number of rows.
         * @return - Entries.
         */
        public List<Entry> getRows(String sql, int maxRows) {

            List<Entry> rows = new ArrayList<>();

            Statement st = null;
            ResultSet rs = null;

            try {
                st = connection.createStatement();

                if (maxRows > 0) {
                    st.setMaxRows(maxRows);
                }

                rs = st.executeQuery(sql);

                while (rs.next()) {
                    rows.add(new Entry(rs.getString(1)));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (rs != null) {
                        rs.close();
                    }
                    if (st != null) {
                        st.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            return rows;
        }


        /**
         * Add in table the number of rows.
         * @param sql - SQL.
         * @param number - number of rows.
         * @return - cumulative record count.
         */
        public int insertMultipleRows(String sql, int number) {

            int insertRows = 0;

            PreparedStatement st = null;

            try {
                st = connection.prepareStatement(sql);

                for (int i = 1; i <= number; i++) {
                    st.setInt(1, i);
                    insertRows += st.executeUpdate();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    st.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            return insertRows;
        }


        /**
         * Update.
         * @param sql - SQL.
         */
        public void update(String sql) {
            Statement st = null;
            try {
                st = connection.createStatement();
                st.executeUpdate(sql);
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    st.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }


}
