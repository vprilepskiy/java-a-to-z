package ru.job4j.controller.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.hibernate.Session;
import org.hibernate.exception.ConstraintViolationException;
import ru.job4j.model.entity.User;
import ru.job4j.model.store.HibernateORM;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by VLADIMIR on 11.03.2018.
 */
public class Registration extends HttpServlet {

    /**
     * Registration new user and add in DB.
     * @param req - Request.
     * @param resp - Response.
     * @throws ServletException - Exception.
     * @throws IOException - Exception.
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/json");

        final ObjectMapper mapper = new ObjectMapper();
        final PrintWriter writer = new PrintWriter(resp.getOutputStream());

        final String login = req.getParameter("login");
        final String password = req.getParameter("password");

        final User user = HibernateORM.getInstance().addUser(login, password);

        if (user != null) {
            // передать в сессию зарегестрировавшегося пользователя
            req.getSession().setAttribute("sessionUser", user);
            // передать статус
            mapper.writeValue(writer, "Ok");
            writer.flush();
        } else {
            // юзера не удалось добавить в БД
            mapper.writeValue(writer, "User witch login already exists!");
            writer.flush();
        }
    }
}
