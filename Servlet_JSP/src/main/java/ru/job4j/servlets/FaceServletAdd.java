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
 * Created by VLADIMIR on 28.11.2017.
 */
public class FaceServletAdd extends HttpServlet {

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

        // кнопка назад
        sb.append("<form action='" + req.getContextPath() + "/face' method='get'>");
        sb.append("     <button type='submit'>Back</button>");
        sb.append("</form><br/>");

        // ввод нового пользователя
        sb.append("    <form action='" + req.getContextPath() + "/face/add' method='post'>");
        sb.append("        Name  : <input type='text' name='name'/><br/>");
        sb.append("        Login : <input type='text' name='login'/><br/>");
        sb.append("        Email : <input type='text' name='email'/><br/><br/>");
        sb.append("        <input type='submit' value='Add'><br/>");
        sb.append("    </form><br/>");


        // добавлено кол-во записей
        final Object rows = req.getAttribute("rows");

        if (rows != null) {
            sb.append("Added users: ");
            sb.append(rows);
        }

        // закрыть теги
        sb.append("</body>");
        sb.append("</html>");

        final PrintWriter writer = new PrintWriter(resp.getOutputStream());
        writer.append(sb);
        writer.flush();
        writer.close();
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        final PrintWriter writer = new PrintWriter(resp.getOutputStream());

        final String name = req.getParameter("name");
        final String login = req.getParameter("login");
        final String email = req.getParameter("email");

        // добавить в БД
        final Integer rows = users.add(new User(name, login, email));
        req.setAttribute("rows", rows);

        this.doGet(req, resp);
    }
}
