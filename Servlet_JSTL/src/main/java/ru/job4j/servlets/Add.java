package ru.job4j.servlets;

import ru.job4j.models.Role;
import ru.job4j.models.User;
import ru.job4j.store.UserStore;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by VLADIMIR on 07.12.2017.
 */
public class Add extends HttpServlet {

    /**
     * User store.
     */
    private final UserStore users = UserStore.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // переадресовать на jsp.
        req.getRequestDispatcher("/WEB-INF/views/add.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");

        final String name = req.getParameter("name");
        final String login = req.getParameter("login");
        final String password = req.getParameter("password");
        final String email = req.getParameter("email");
        final Role role = new Role(req.getParameter("role"));

        // добавить в БД
        final Integer rows = this.users.add(new User(name, login, password, email, role));
        req.setAttribute("rows", rows);

        // вернуться на исходную страницу add
        this.doGet(req, resp);
    }
}
