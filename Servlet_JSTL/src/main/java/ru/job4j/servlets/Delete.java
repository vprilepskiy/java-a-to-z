package ru.job4j.servlets;

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
public class Delete extends HttpServlet {

    /**
     * User store.
     */
    private final UserStore users = UserStore.getInstance();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // передать параметр в атрибут
        req.setAttribute("userName", req.getParameter("userName"));

        // переадресовать на jsp.
        req.getRequestDispatcher("/WEB-INF/views/delete.jsp").forward(req, resp);

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        final String userName = req.getParameter("userName");

        // удалить запись из БД
        final Integer rows = users.delete(new User(userName));
        req.setAttribute("rows", rows);

        // перенаправить на стартовую страницу
        resp.sendRedirect(String.format("%s/", req.getContextPath()));
    }
}
