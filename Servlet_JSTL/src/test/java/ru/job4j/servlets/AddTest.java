package ru.job4j.servlets;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import ru.job4j.models.Role;
import ru.job4j.models.User;
import ru.job4j.store.UserStore;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by VLADIMIR on 20.12.2017.
 */
public class AddTest {


    /**
     * Test.
     * @throws ServletException - ex.
     * @throws IOException - ex.
     */
    public void doPostTest() throws ServletException, IOException {
        // затычки
        final HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        final HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
        final RequestDispatcher dispatcher = Mockito.mock(RequestDispatcher.class);

        final User user = new User("test_name", "test_login", "test_password", "test_email", new Role("User"));

        // передать в request
        Mockito.when(request.getParameter("name")).thenReturn(user.getName());
        Mockito.when(request.getParameter("login")).thenReturn(user.getLogin());
        Mockito.when(request.getParameter("password")).thenReturn(user.getPassword());
        Mockito.when(request.getParameter("email")).thenReturn(user.getEmail());
        Mockito.when(request.getParameter("role")).thenReturn(user.getRole().getDescription());
        Mockito.when(request.getRequestDispatcher("/WEB-INF/views/add.jsp")).thenReturn(dispatcher);

        // добавить юзера в БД сервлетом
        new Add().doPost(request, response);
        // получить из БД всех юзеров
        final List<User> users = UserStore.getInstance().get();
        // найти этого юзера
        Assert.assertTrue(users.contains(user));
    }
}