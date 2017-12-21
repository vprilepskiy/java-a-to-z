package ru.job4j.servlets;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import ru.job4j.models.Role;
import ru.job4j.models.User;
import ru.job4j.store.UserStore;

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
     * Override forward to jsp.
     */
    class Add extends ru.job4j.servlets.Add {
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            // none
        }
    }


    /**
     * Test.
     * @throws ServletException - ex.
     * @throws IOException - ex.
     */
    public void doPostTest() throws ServletException, IOException {
        // затычки
        final HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        final HttpServletResponse response = Mockito.mock(HttpServletResponse.class);

        final User user = new User("test_name", "test_login", "test_password", "test_email", new Role("User"));

        // передать в request
        Mockito.when(request.getParameter("name")).thenReturn(user.getName());
        Mockito.when(request.getParameter("login")).thenReturn(user.getLogin());
        Mockito.when(request.getParameter("password")).thenReturn(user.getPassword());
        Mockito.when(request.getParameter("email")).thenReturn(user.getEmail());
        Mockito.when(request.getParameter("role")).thenReturn(user.getRole().getDescription());

        // добавить юзера в БД сервлетом
        new Add().doPost(request, response);
        // получить из БД всех юзеров
        final List<User> users = UserStore.getInstance().get();
        // найти этого юзера
        Assert.assertTrue(users.contains(user));
    }
}