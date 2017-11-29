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
public class FaceServletUpdate extends HttpServlet {

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

        // получить редактируемого пользователя
        final String userName = req.getParameter("userName");
        final User user = this.users.getByName(new User(userName));

        // редактрирование пользователя
        sb.append("    <form action='" + req.getContextPath() + "/face/update' method='post'>");
        sb.append("        Name  : <input value='" + user.getName() + "' type='text' name='name' readonly/><br/>");
        sb.append("        Login : <input value='" + user.getLogin() + "' type='text' name='login'/><br/>");
        sb.append("        Email : <input value='" + user.getEmail() + "' type='text' name='email'/><br/><br/>");
        sb.append("        <input type='submit' value='Update'><br/>");
        sb.append("    </form><br/>");


        // обновлено записей
        final Object rows = req.getAttribute("rows");

        if (rows != null) {
            sb.append("Updated users: ");
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

        // обновить в БД
        final Integer rows = users.edit(new User(name, login, email));
        req.setAttribute("rows", rows);

        this.doGet(req, resp);
    }
}
