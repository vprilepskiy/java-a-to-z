package ru.job4j.servlets.json;

import ru.job4j.models.User;
import ru.job4j.store.UserStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by VLADIMIR on 07.12.2017.
 */
public class DeleteUser extends HttpServlet {

    /**
     * User store.
     */
    private final UserStore users = UserStore.getInstance();


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        final String userName = req.getParameter("name");

        // удалить запись из БД
        users.delete(new User(userName));
    }
}
