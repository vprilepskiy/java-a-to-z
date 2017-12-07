package ru.job4j.servlets;

import ru.job4j.models.User;
import ru.job4j.store.UserStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by VLADIMIR on 07.12.2017.
 */
public class Update extends HttpServlet {

    /**
     * User store.
     */
    private final UserStore users = UserStore.getInstance();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // получить имя пользователя
        final String userName = req.getParameter("userName");
        // запросить в БД юзера
        final User user = this.users.getByName(new User(userName));
        // передать юзера в ответ
        req.setAttribute("user", user);

        // переадресовать на jsp.
        req.getRequestDispatcher("/WEB-INF/views/update.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        final String name = req.getParameter("name");
        final String login = req.getParameter("login");
        final String email = req.getParameter("email");

        // редактировать запись в БД
        final Integer rows = users.edit(new User(name, login, email));
        req.setAttribute("rows", rows);

        // вернуться на исходную страницу update
        this.doGet(req, resp);
    }
}
