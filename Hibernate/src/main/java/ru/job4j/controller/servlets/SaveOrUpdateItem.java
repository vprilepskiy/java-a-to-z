package ru.job4j.controller.servlets;

import ru.job4j.model.entity.Item;
import ru.job4j.model.store.HibernateORM;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;

/**
 * Created by VLADIMIR on 15.02.2018.
 */
public class SaveOrUpdateItem extends HttpServlet {

    /**
     * Save or update item.
     * @param req - req.
     * @param resp - resp.
     * @throws ServletException - exception.
     * @throws IOException - exception.
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        final int id = Integer.parseInt(req.getParameter("item_id"));
        final String desc = req.getParameter("item_description");
        final Timestamp created = new Timestamp(System.currentTimeMillis());
        final boolean done = Boolean.parseBoolean(req.getParameter("item_done"));

        HibernateORM.getInstance().saveOrUpdate(new Item(id, desc, created, done));
    }
}
