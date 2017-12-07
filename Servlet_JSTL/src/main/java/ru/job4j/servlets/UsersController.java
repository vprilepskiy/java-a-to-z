package ru.job4j.servlets;

import ru.job4j.Settings;
import ru.job4j.models.User;
import ru.job4j.store.UserStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Точка входа.
 *
 *
 * Created by VLADIMIR on 07.12.2017.
 */
public class UsersController extends HttpServlet {

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



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // получить всех пользователей
        final List<User> users = this.users.get();
        // передать в ответ
        req.setAttribute("users", users);
        // переадресовать на jsp.
        req.getRequestDispatcher("/WEB-INF/views/UsersView.jsp").forward(req, resp);
    }



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
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
