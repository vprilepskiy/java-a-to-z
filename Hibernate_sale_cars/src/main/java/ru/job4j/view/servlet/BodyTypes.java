package ru.job4j.view.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.hibernate.Session;
import ru.job4j.model.entity.BodyType;
import ru.job4j.model.store.HibernateORM;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by VLADIMIR on 12.03.2018.
 */
public class BodyTypes extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/json");

        final ObjectMapper mapper = new ObjectMapper();
        final PrintWriter writer = new PrintWriter(resp.getOutputStream());

        try (Session session = HibernateORM.getInstance().getSessionFactory().openSession()) {
            session.beginTransaction();

            List<BodyType> bodyTypes = session.createQuery("from BodyType", BodyType.class).list();

            session.getTransaction().commit();

            mapper.writeValue(writer, bodyTypes);
            writer.flush();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
