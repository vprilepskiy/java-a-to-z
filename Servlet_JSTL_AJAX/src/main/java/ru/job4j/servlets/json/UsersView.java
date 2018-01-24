package ru.job4j.servlets.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.job4j.models.Role;
import ru.job4j.models.User;
import ru.job4j.store.UserStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Created by VLADIMIR on 11.01.2018.
 */
public class UsersView extends HttpServlet {

    /**
     * User store.
     */
    private final UserStore users = UserStore.getInstance();


    /**
     * Отправит список доступных для редактрирования пользователей.
     * @param req - request.
     * @param resp - response.
     * @throws ServletException - Exception.
     * @throws IOException - Exception.
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/json");

        // получить сессию
        final HttpSession session = req.getSession();

        // передать в сессию список доступных для редактрирования пользователей и ролей.
        this.setSessionParameters(req);

        // получить список юзеров для редактирования
        List<User> usersForEdit = (List<User>) session.getAttribute("users");

        // JACKSON
        final ObjectMapper mapper = new ObjectMapper();

        // отправить ответ
        final PrintWriter writer = new PrintWriter(resp.getOutputStream());
        mapper.writeValue(writer, usersForEdit);

        writer.flush();
        writer.close();
    }


    /**
     * Передать в сессию список доступных для редактрирования пользователей и ролей.
     * @param req - request.
     */
    private void setSessionParameters(HttpServletRequest req) {
        // получить сессию
        final HttpSession session = req.getSession();
        // получить текущего юзера и его роль
        final User sessionUser = (User) session.getAttribute("sessionUser");
        final Role role = sessionUser.getRole();
        final Set<String> rightsUser = role.getRights();

        // Список юзеров для редактирования
        List<User> usersForEdit = null;
        // Список доступных ролей для этого юзера.
        List<Role> rolesForEdit = null;


        // если пользователь активный
        if (rightsUser.contains("Active")) {
            // если Админ
            if (rightsUser.contains("Edit_All_Users")) {
                // все пользователи
                usersForEdit = this.users.get();
                // все роли
                rolesForEdit = this.users.getRoles();
            } else {
                // только себя
                usersForEdit = new LinkedList();
                usersForEdit.add(sessionUser);

                rolesForEdit = new LinkedList();
                rolesForEdit.add(role);
            }
        }

        // передать в сессию
        session.setAttribute("users", usersForEdit);
        session.setAttribute("roles", rolesForEdit);

    }
}
