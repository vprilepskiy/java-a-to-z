package ru.job4j.servlets.json;

import ru.job4j.models.Role;
import ru.job4j.models.User;
import ru.job4j.store.UserStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by VLADIMIR on 07.12.2017.
 */
public class AddUser extends HttpServlet {

    /**
     * User store.
     */
    private final UserStore users = UserStore.getInstance();

    /**
     * Добавить пользователя в БД.
     * @param req - request.
     * @param resp - response.
     * @throws ServletException - ServletException.
     * @throws IOException - IOException.
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        final String name = req.getParameter("name");
        final String login = req.getParameter("login");
        final String password = req.getParameter("password");
        final String email = req.getParameter("email");
        final Role role = new Role(req.getParameter("role"));
        final String country = req.getParameter("country");
        final String city = req.getParameter("city");

        // добавить в БД
        this.users.add(new User(name, login, password, email, role, country, city));
    }
}
