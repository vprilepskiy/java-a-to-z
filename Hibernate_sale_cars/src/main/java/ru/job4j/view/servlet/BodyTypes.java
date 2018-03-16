package ru.job4j.view.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.job4j.model.store.HibernateORM;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by VLADIMIR on 12.03.2018.
 */
public class BodyTypes extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/json");

        final ObjectMapper mapper = new ObjectMapper();
        final PrintWriter writer = new PrintWriter(resp.getOutputStream());

        mapper.writeValue(writer, HibernateORM.getInstance().getBodyTapes());
        writer.flush();
    }



}
