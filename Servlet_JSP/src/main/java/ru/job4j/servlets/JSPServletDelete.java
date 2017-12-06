package ru.job4j.servlets;

import ru.job4j.models.User;
import ru.job4j.store.UserStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by VLADIMIR on 05.12.2017.
 */
public class JSPServletDelete extends HttpServlet {

    /**
     * User store.
     */
    private final UserStore users = UserStore.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // получить редактируемого пользователя
        final String userName = req.getParameter("userName");

        // удалить из БД
        this.users.delete(new User(userName));

        // перенаправить на стартовую страницу
        resp.sendRedirect(String.format("%s/index.jsp", req.getContextPath()));
    }
}
