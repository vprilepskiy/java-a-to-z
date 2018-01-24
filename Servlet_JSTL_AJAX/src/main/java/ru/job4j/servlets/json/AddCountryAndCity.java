package ru.job4j.servlets.json;

import ru.job4j.store.UserStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by VLADIMIR on 22.01.2018.
 */
public class AddCountryAndCity extends HttpServlet {

    /**
     * User store.
     */
    private final UserStore users = UserStore.getInstance();


    /**
     * Добавить в БД страну и город.
     * @param req - request.
     * @param resp - response.
     * @throws ServletException - ServletException.
     * @throws IOException - IOException.
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        final String country = req.getParameter("country");
        final String city = req.getParameter("city");

        this.users.addCountry(country);
        this.users.addCity(country, city);

    }
}
