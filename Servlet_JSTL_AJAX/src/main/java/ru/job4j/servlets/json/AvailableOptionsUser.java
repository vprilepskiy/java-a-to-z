package ru.job4j.servlets.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.job4j.models.Role;
import ru.job4j.store.UserStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by VLADIMIR on 19.01.2018.
 */
public class AvailableOptionsUser extends HttpServlet {

    /**
     * User store.
     */
    private final UserStore users = UserStore.getInstance();

    /**
     * Передать список доступных ролей и стран.
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

        // Список доступных ролей для этого юзера.
        final List<Role> rolesForEdit = (List<Role>) session.getAttribute("roles");

        // получить список доступных стран
        final List<String> countries = this.users.getCountries();

        // JACKSON
        final ObjectMapper mapper = new ObjectMapper();

        /**
         * Объект для отправки.
         */
        final class ForSend {
            final List<Role> rolesForEdit;
            final List<String> countries;

            public ForSend(List<Role> rolesForEdit, List<String> countries) {
                this.rolesForEdit = rolesForEdit;
                this.countries = countries;
            }

            public List<Role> getRolesForEdit() {
                return rolesForEdit;
            }

            public List<String> getCountries() {
                return countries;
            }
        }

        // отправить пользователю
        final PrintWriter writer = new PrintWriter(resp.getOutputStream());
        mapper.writeValue(writer, new ForSend(rolesForEdit, countries));

        writer.flush();
        writer.close();
    }


    /**
     * Передать список доступных городов для этой страны.
     * @param req - request.
     * @param resp - response.
     * @throws ServletException - Exception.
     * @throws IOException - Exception.
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/json");

        final String country = req.getParameter("country");

        final List<String> cities = this.users.getCitiesByCountry(country);

        // JACKSON
        final ObjectMapper mapper = new ObjectMapper();

        // отправить пользователю
        final PrintWriter writer = new PrintWriter(resp.getOutputStream());
        mapper.writeValue(writer, cities);

        writer.flush();
        writer.close();
    }
}
