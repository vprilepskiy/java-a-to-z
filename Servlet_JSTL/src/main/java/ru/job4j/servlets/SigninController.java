package ru.job4j.servlets;

import ru.job4j.models.Role;
import ru.job4j.models.User;
import ru.job4j.store.UserStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by VLADIMIR on 11.12.2017.
 */
public class SigninController extends HttpServlet {

    private final UserStore users = UserStore.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/LoginView.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        final String login = req.getParameter("login");
        final String password = req.getParameter("password");

        // если логин пароль совпали
        if (this.users.isCredentional(login, password)) {

            // получить юзера
            final User sessionUser = this.users.getByLoginPass(login, password);

            // получить сессию
            final HttpSession session = req.getSession();

            // передать в сессию текущего юзера
            session.setAttribute("sessionUser", sessionUser);

            resp.sendRedirect(String.format("%s/", req.getContextPath()));

        } else {
            req.setAttribute("error", "Credentional invalid");
            this.doGet(req, resp);
        }

    }
}
