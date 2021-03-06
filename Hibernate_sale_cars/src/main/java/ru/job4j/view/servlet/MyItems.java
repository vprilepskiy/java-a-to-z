package ru.job4j.view.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.hibernate.Session;
import org.hibernate.query.Query;
import ru.job4j.model.entity.Item;
import ru.job4j.model.entity.User;
import ru.job4j.model.store.HibernateORM;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by VLADIMIR on 13.03.2018.
 */
public class MyItems extends HttpServlet {

    /**
     * My items.
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/json");

        final ObjectMapper mapper = new ObjectMapper();
        final PrintWriter writer = new PrintWriter(resp.getOutputStream());
        User user = (User) req.getSession().getAttribute("sessionUser");

        mapper.writeValue(writer, HibernateORM.getInstance().getItems(user));
        writer.flush();
    }
}
