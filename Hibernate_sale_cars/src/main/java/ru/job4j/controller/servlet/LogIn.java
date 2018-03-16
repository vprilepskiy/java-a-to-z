package ru.job4j.controller.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ru.job4j.model.entity.User;
import ru.job4j.model.store.HibernateORM;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * Created by VLADIMIR on 02.02.2018.
 */
public class LogIn extends HttpServlet {

    /**
     * Set user in session.
     * @param req - request login, password.
     * @param resp - Send json object with status and url on next page.
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

        final User user = HibernateORM.getInstance().getUserByLoginPass(login, password);

        if (user != null) {
            // передать в сессию залогиненного пользователя
            req.getSession().setAttribute("sessionUser", user);
            // передать статус
            mapper.writeValue(writer, "Ok");
            writer.flush();
        } else {
            mapper.writeValue(writer, "Invalid Login/Password");
            writer.flush();
        }
    }
}
