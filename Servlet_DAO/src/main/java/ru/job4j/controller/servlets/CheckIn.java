package ru.job4j.controller.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import com.fasterxml.jackson.databind.ObjectMapper;


/**
 * Created by VLADIMIR on 02.02.2018.
 */
public class CheckIn extends HttpServlet {

    /**
     * Set user in session.
     * @param req - request login, password.
     * @param resp - Send json object with status and url on next page.
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/json");

        final ObjectMapper mapper = new ObjectMapper();
        final PrintWriter writer = new PrintWriter(resp.getOutputStream());

        final String login = req.getParameter("login");
        final String password = req.getParameter("password");

        // get user
        final ru.job4j.model.entity.User user = this.getUserByLoginPass(login, password);


        final class ForSend {
            final String status;
            final String url;

            public ForSend(String status, String url) {
                this.status = status;
                this.url = url;
            }

            public String getStatus() {
                return status;
            }

            public String getUrl() {
                return url;
            }
        }


        if (user != null) {
            // передать в сессию залогиненного пользователя
            req.getSession().setAttribute("sessionUser", user);
            // передать url страницы пользователей
            String url = String.format("%s/UsersView.html", req.getContextPath());
            mapper.writeValue(writer, new ForSend("Ok", url));
            writer.flush();
            writer.close();
        } else {
            mapper.writeValue(writer, new ForSend("Invalid Login/Password", null));
            writer.flush();
            writer.close();
        }
    }


    /**
     * Get User by Login Password.
     * @param login
     * @param password
     * @return
     */
    private ru.job4j.model.entity.User getUserByLoginPass(String login, String password) {
        ru.job4j.model.entity.User result = null;

        final ru.job4j.model.store.dao.User daoUser = new ru.job4j.model.store.dao.User();

        for (ru.job4j.model.entity.User user : daoUser.read()) {
            if ((user.getLogin().equals(login)) && (user.getPassword().equals(password))) {
                result = user;
            }
        }

        return result;
    }
}
