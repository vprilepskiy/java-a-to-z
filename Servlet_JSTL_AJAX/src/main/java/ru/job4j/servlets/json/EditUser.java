package ru.job4j.servlets.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.job4j.models.Role;
import ru.job4j.models.User;
import ru.job4j.store.UserStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by VLADIMIR on 07.12.2017.
 */
public class EditUser extends HttpServlet {

    /**
     * User store.
     */
    private final UserStore users = UserStore.getInstance();


    /**
     * Запросить в БД данные пользователя по имени.
     * @param req - request.
     * @param resp - response.
     * @throws ServletException - ServletException.
     * @throws IOException - IOException.
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/json");

        // получить имя пользователя
        final String userName = req.getParameter("name");
        // запросить в БД юзера по имени
        final User user = this.users.getByName(new User(userName));

        // JACKSON
        final ObjectMapper mapper = new ObjectMapper();

        // отправить в ответ пользователя
        final PrintWriter writer = new PrintWriter(resp.getOutputStream());
        mapper.writeValue(writer, user);

        writer.flush();
        writer.close();
    }


    /**
     * Отослать измененные данные пользователя в БД.
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        final String name = req.getParameter("name");
        final String login = req.getParameter("login");
        final String password = req.getParameter("password");
        final String email = req.getParameter("email");
        final Role role = new Role(req.getParameter("role"));
        final String country = req.getParameter("country");
        final String city = req.getParameter("city");

        // редактировать запись в БД
        users.edit(new User(name, login, password, email, role, country, city));
    }
}
