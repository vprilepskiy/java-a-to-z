package ru.job4j.view.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.job4j.model.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by VLADIMIR on 02.02.2018.
 */
public class UsersView extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/json");

        final ObjectMapper mapper = new ObjectMapper();
        final PrintWriter writer = new PrintWriter(resp.getOutputStream());

        final ru.job4j.model.entity.User user = (User) req.getSession().getAttribute("sessionUser");
        final List<ru.job4j.model.entity.User> users;

        if(user != null) {
            users = new ru.job4j.model.store.dao.User().read();
            mapper.writeValue(writer, users);
            writer.flush();
            writer.close();
        }
    }
}
