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

import static org.junit.Assert.*;

/**
 * Created by VLADIMIR on 21.12.2017.
 */
public class DeleteTest {



    /**
     * Test.
     * @throws Exception - ex.
     */
    public void doPostTest() throws Exception {
        // затычки
        final HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        final HttpServletResponse response = Mockito.mock(HttpServletResponse.class);

        final UserStore users = UserStore.getInstance();
        // добавить юзера в БД
        final User newUser = new User("test_name", "test_login", "test_password", "test_email", new Role("User"));
        users.add(newUser);

        // передать в request
        Mockito.when(request.getParameter("userName")).thenReturn(newUser.getName());

        // удалить юзера в БД сервлетом
        new Delete().doPost(request, response);
        // получить из БД всех юзеров
        final List<User> listUsers = users.get();
        // найти этого юзера
        Assert.assertFalse(listUsers.contains(newUser));
    }
}