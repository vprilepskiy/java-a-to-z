package ru.job4j.servlets.json;

import ru.job4j.Settings;
import ru.job4j.store.UserStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

/**
 * Created by VLADIMIR on 15.01.2018.
 */
public class ConnDB extends HttpServlet {

    /**
     * User store.
     */
    private final UserStore users = UserStore.getInstance();
    /**
     * Settings.
     */
    private final Settings settings = new Settings("store.properties");

    /**
     * Connect to Data Base.
     * @throws ServletException - ex.
     */
    @Override
    public void init() throws ServletException {
        final String url = settings.getValue("db_url");
        final String username = settings.getValue("db_username");
        final String password = settings.getValue("db_password");
        this.users.setConnection(url, username, password);

        System.out.println(" *** CONNECTION DATA BASE ***");
    }


    /**
     * Close resources.
     */
    @Override
    public void destroy() {
        this.users.closeConnection();
        System.out.println(" *** CLOSE CONNECTION DATA BASE ***");
    }
}
