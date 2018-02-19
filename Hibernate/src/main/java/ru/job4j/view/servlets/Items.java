package ru.job4j.view.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.job4j.model.entity.Item;
import ru.job4j.model.store.HibernateORM;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by VLADIMIR on 14.02.2018.
 */
public class Items extends HttpServlet {

    /**
     * Send Items.
     * @param req - req.
     * @param resp - resp.
     * @throws ServletException - exception.
     * @throws IOException - exception.
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/json");

        final boolean viewAllItems = Boolean.parseBoolean(req.getParameter("view_all_items"));

        final List<Item> items = HibernateORM.getInstance().getItems(viewAllItems);

        // JACKSON
        final ObjectMapper mapper = new ObjectMapper();

        // send response
        try (final PrintWriter writer = new PrintWriter(resp.getOutputStream())) {
            mapper.writeValue(writer, items);
            writer.flush();
        }

    }
}
