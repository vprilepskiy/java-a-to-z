package ru.job4j.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by VLADIMIR on 05.12.2017.
 */
public class JSPServletAdd extends FaceServletAdd {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // перенаправить на страницу добавления записи
        resp.sendRedirect(String.format("%s/add.jsp?rows=%s", req.getContextPath(), req.getAttribute("rows")));
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // использовать старую реализацию
        super.doPost(req, resp);
    }
}
