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


        try (Session session = HibernateORM.getInstance().getSessionFactory().openSession()) {
            session.beginTransaction();

            final CriteriaBuilder builder = session.getCriteriaBuilder();
            final CriteriaQuery<Item> queryRoot = builder.createQuery(Item.class);
            final Root<Item> root = queryRoot.from(Item.class);
            queryRoot.select(root);

            // условия выборки
            List<Predicate> predicates = new LinkedList<>();
            // только активные
            predicates.add(builder.equal(root.get("active"), true));
            // за сегодня
            if (today) {
                predicates.add(builder.between(root.get("created"), this.startOfDay(), this.endOfDay()));
            }
            // только с фото
            if (withPhoto) {
                predicates.add(builder.isNotNull(root.get("photo")));
            }
            // определенной марки
            if (markId != 0) {
                Mark mark = session.get(Mark.class, markId);
                predicates.add(builder.equal(root.get("mark"), mark));
            }

            // установить условия
            queryRoot.where(builder.and(
                    predicates.toArray(new Predicate[predicates.size()])
            ));

            // сортировать по id.
            queryRoot.orderBy(builder.asc(root.get("id")));

            Query<Item> query = session.createQuery(queryRoot);
            List<Item> items = query.list();

            session.getTransaction().commit();

            mapper.writeValue(writer, items);
            writer.flush();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private Timestamp startOfDay() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return new Timestamp(calendar.getTimeInMillis());
    }


    private Timestamp endOfDay() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        return new Timestamp(calendar.getTimeInMillis());
    }

}


