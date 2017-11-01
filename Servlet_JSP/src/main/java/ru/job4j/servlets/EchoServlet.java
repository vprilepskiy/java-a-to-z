package ru.job4j.servlets;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by VLADIMIR on 26.10.2017.
 */
public class EchoServlet extends HttpServlet {

    private static final Logger log = Logger.getLogger(EchoServlet.class);

    /**
     *
     * @param req - Получил от клиента.
     * @param resp - Ответ для клиента.
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("run doGet");

        resp.setContentType("text/html");
        resp.getOutputStream().write("hello world".getBytes());
//        PrintWriter writer = new PrintWriter(resp.getOutputStream());
//        writer.append("hello world");
//        writer.flush();
//        writer.close();
    }
}
