package ru.job4j.controller.servlet;

import org.hibernate.Session;
import ru.job4j.model.entity.*;
import ru.job4j.model.entity.Item;
import ru.job4j.model.store.HibernateORM;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by VLADIMIR on 13.03.2018.
 */
public class SetStateItem extends HttpServlet {

    /**
     * Set boolean value: active/nonactive.
     * @param req - Request
     * @param resp - Response.
     * @throws ServletException - Exception.
     * @throws IOException - Exception.
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User user = (User) req.getSession().getAttribute("sessionUser");

        if (user == null) {
            throw new NullPointerException();
        }

        int itemId = Integer.parseInt(req.getParameter("item_id"));
        boolean state = Boolean.parseBoolean(req.getParameter("state"));

        HibernateORM.getInstance().setActive(itemId, state);
    }
}
