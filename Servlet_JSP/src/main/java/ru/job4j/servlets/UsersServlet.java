package ru.job4j.servlets;

import ru.job4j.Settings;
import ru.job4j.models.User;
import ru.job4j.store.UserStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by VLADIMIR on 22.11.2017.
 */
public class UsersServlet extends HttpServlet {

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
     * Get users.
     * @param req - Request.
     * @param resp - Response.
     * @throws ServletException - exception.
     * @throws IOException - exception.
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        final List<User> userList = users.get();
        final PrintWriter writer = new PrintWriter(resp.getOutputStream());

        for (User user : userList) {
            writer.append(user.toString());
            writer.append("\r\n");
        }

        writer.flush();
        writer.close();
    }


    /**
     * Create user.
     * @param req - Request.
     * @param resp - Response.
     * @throws ServletException - exception.
     * @throws IOException - exception.
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        final String name = req.getParameter("name");
        final String login = req.getParameter("login");
        final String email = req.getParameter("email");
        final int insertRows = this.users.add(new User(name, login, email));

        final PrintWriter writer = new PrintWriter(resp.getOutputStream());
        writer.append("insertRows=");
        writer.append(String.valueOf(insertRows));
        writer.flush();
        writer.close();
    }


    /**
     * Edit user.
     * @param req - Request.
     * @param resp - Response.
     * @throws ServletException - exception.
     * @throws IOException - exception.
     */
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        final String name = req.getParameter("name");
        final String login = req.getParameter("login");
        final String email = req.getParameter("email");
        final int updateRows = this.users.edit(new User(name, login, email));

        final PrintWriter writer = new PrintWriter(resp.getOutputStream());
        writer.append("updateRows=");
        writer.append(String.valueOf(updateRows));
        writer.flush();
        writer.close();
    }


    /**
     * Delete user.
     * @param req - Request.
     * @param resp - Response.
     * @throws ServletException - exception.
     * @throws IOException - exception.
     */
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        final String name = req.getParameter("name");
        final int deleteRows = this.users.delete(new User(name));

        final PrintWriter writer = new PrintWriter(resp.getOutputStream());
        writer.append("deleteRows=");
        writer.append(String.valueOf(deleteRows));
        writer.flush();
        writer.close();
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
