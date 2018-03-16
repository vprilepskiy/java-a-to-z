package ru.job4j.controller.servlet;

import org.hibernate.Session;
import org.hibernate.exception.ConstraintViolationException;
import ru.job4j.model.entity.BodyType;
import ru.job4j.model.entity.Mark;
import ru.job4j.model.entity.Model;
import ru.job4j.model.entity.User;
import ru.job4j.model.store.HibernateORM;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;

/**
 * Created by VLADIMIR on 12.03.2018.
 */
public class Item extends HttpServlet {

    /**
     * Add new Item in DB.
     * @param req - Request.
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

        int markId = Integer.parseInt(req.getParameter("mark_id"));
        int modelId = Integer.parseInt(req.getParameter("model_id"));
        int bodyTypeId = Integer.parseInt(req.getParameter("body_type_id"));
        int year = Integer.parseInt(req.getParameter("year"));
        int price = Integer.parseInt(req.getParameter("price"));

        // add new Item in DB.
        HibernateORM.getInstance().addItem(user, markId, modelId, bodyTypeId, year, price);
    }
}
