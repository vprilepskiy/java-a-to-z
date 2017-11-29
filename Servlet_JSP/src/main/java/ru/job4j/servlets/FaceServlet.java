package ru.job4j.servlets;

import ru.job4j.models.User;
import ru.job4j.store.UserStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by VLADIMIR on 27.11.2017.
 */
public class FaceServlet extends HttpServlet {

    /**
     * User store.
     */
    private final UserStore users = UserStore.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");

        final StringBuilder sb = new StringBuilder();

        // head
        sb.append("<!DOCTYPE html> <html lang='en'>");
        sb.append("    <meta charset='UTF-8'>");
        sb.append("    <title>Title</title>");
        sb.append("</head>");
        sb.append("<body>");


        // таблица
        sb.append("<table border='1'>");
        // заголовки таблицы
        sb.append("    <tr>");
        sb.append("        <th>Name</th>");
        sb.append("        <th>Login</th>");
        sb.append("        <th>Email</th>");
        sb.append("    </tr>");

        // тело таблицы
        for (User user : users.get()) {
            sb.append("<tr>");
            sb.append("    <td>").append(user.getName()).append("</td>");
            sb.append("    <td>").append(user.getLogin()).append("</td>");
            sb.append("    <td>").append(user.getEmail()).append("</td>");
            // кнопка UPDATE
            sb.append("    <td>");
            sb.append("        <form action='" + req.getContextPath() + "/face/update' method='get'>");
            sb.append("            <button value='" + user.getName() + "' name='userName' type='submit'>Update</button>");
            sb.append("        </form>");
            sb.append("    </td>");
            // кнопка DELETE
            sb.append("    <td>");
            sb.append("        <form action='" + req.getContextPath() + "/face/delete' method='get'>");
            sb.append("            <button value='" + user.getName() + "' name='userName' type='submit'>Delete</button>");
            sb.append("        </form>");
            sb.append("    </td>");
            sb.append("</tr>");
        }
        sb.append("</table><br/>");

        // кнопка ADD
        sb.append("<form action='" + req.getContextPath() + "/face/add' method='get'>");
        sb.append("  <button type='submit'>Add</button>");
        sb.append("</form>");

        // закрыть теги
        sb.append("</body>");
        sb.append("</html>");

        final PrintWriter writer = new PrintWriter(resp.getOutputStream());
        writer.append(sb);
        writer.flush();
        writer.close();
    }
}
