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

import static org.junit.Assert.*;

/**
 * Created by VLADIMIR on 21.12.2017.
 */
public class UpdateTest {


    /**
     * Test.
     * @throws Exception - ex.
     */
    public void doPostTest() throws Exception {
        // затычки
        final HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        final HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
        final RequestDispatcher dispatcher = Mockito.mock(RequestDispatcher.class);

        final UserStore users = UserStore.getInstance();
        // добавить юзера в БД
        final User newUser = new User("test_name", "test_login", "test_password", "test_email", new Role("User"));
        users.add(newUser);
        // создать редактируемого с таким же именем
        final User editUser = new User("test_name", "editing_login", "editing_password", "editing_email", new Role("User"));

        // передать в request
        Mockito.when(request.getParameter("name")).thenReturn(editUser.getName());
        Mockito.when(request.getParameter("login")).thenReturn(editUser.getLogin());
        Mockito.when(request.getParameter("password")).thenReturn(editUser.getPassword());
        Mockito.when(request.getParameter("email")).thenReturn(editUser.getEmail());
        Mockito.when(request.getParameter("role")).thenReturn(editUser.getRole().getDescription());
        Mockito.when(request.getRequestDispatcher("/WEB-INF/views/update.jsp")).thenReturn(dispatcher);

        // обновить юзера в БД сервлетом
        new Update().doPost(request, response);
        // получить из БД всех юзеров
        final List<User> listUsers = users.get();
        // найти этого юзера
        Assert.assertTrue(listUsers.contains(editUser));
    }
}