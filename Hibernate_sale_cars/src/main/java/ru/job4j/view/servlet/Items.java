package ru.job4j.view.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import ru.job4j.model.entity.Item;
import ru.job4j.model.entity.Mark;
import ru.job4j.model.entity.User;
import ru.job4j.model.store.HibernateORM;


import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.*;

/**
 * Created by VLADIMIR on 06.03.2018.
 */
public class Items extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/json");

        final ObjectMapper mapper = new ObjectMapper();
        final PrintWriter writer = new PrintWriter(resp.getOutputStream());

        // for CriteriaBuilder
        boolean today = Boolean.parseBoolean(req.getParameter("today"));
        boolean withPhoto = Boolean.parseBoolean(req.getParameter("with_photo"));
        int markId = Integer.parseInt(req.getParameter("mark_id"));

        mapper.writeValue(writer, HibernateORM.getInstance().getItems(today, withPhoto, markId));
        writer.flush();
    }
}


