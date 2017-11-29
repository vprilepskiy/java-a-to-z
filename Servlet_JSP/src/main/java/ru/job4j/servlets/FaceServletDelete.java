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
public class FaceServletDelete extends HttpServlet {

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

        final String userName = req.getParameter("userName");

        // уверен?
        sb.append("<h3>Delete user: '" + userName + "' ?</h3><br/>");

        // кнопка Да
        sb.append("<form action='" + req.getContextPath() + "/face/delete' method='post'>");
        sb.append("  <button value='" + userName + "' name='userName' type='submit'>Yes</button>");
        sb.append("</form>");

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

        // получить редактируемого пользователя
        final String userName = req.getParameter("userName");

        // удалить из БД
        this.users.delete(new User(userName));

        // перенаправить на стартовую страницу
        resp.sendRedirect(req.getContextPath() + "/face");
    }

}
