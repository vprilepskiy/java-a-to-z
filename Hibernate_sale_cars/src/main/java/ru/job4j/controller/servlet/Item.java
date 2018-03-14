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

        try (Session session = HibernateORM.getInstance().getSessionFactory().openSession()) {
            session.beginTransaction();

            Mark mark = session.get(Mark.class, markId);
            Model model = session.get(Model.class, modelId);
            BodyType bodyType = session.get(BodyType.class, bodyTypeId);

            ru.job4j.model.entity.Item item = new ru.job4j.model.entity.Item();
            item.setMark(mark);
            item.setModel(model);
            item.setBodyType(bodyType);
            item.setYear(year);
            item.setPrice(price);
            item.setActive(true);
            item.setCreated(new Timestamp(System.currentTimeMillis()));

            // добавить объявление
            int id = (int) session.save(item);

            // привязать это объявление к текущему юзеру.
            session.get(User.class, user.getId()).getItems().add(item);

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
