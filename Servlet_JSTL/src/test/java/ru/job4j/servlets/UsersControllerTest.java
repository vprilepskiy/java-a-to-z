package ru.job4j.servlets;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.job4j.models.User;
import ru.job4j.store.UserStore;
import javax.servlet.ServletException;
import java.io.IOException;
import java.util.List;


/**
 * Created by VLADIMIR on 19.12.2017.
 */
public class UsersControllerTest {

    /**
     * User controller.
     */
    private UsersController controller;


    @Before
    public void init() throws ServletException {
        this.controller = new UsersController();
        this.controller.init();
    }


    @Test
    public void initTest() throws Exception {

        new AddTest().doPostTest();
        new UpdateTest().doPostTest();
        new DeleteTest().doPostTest();

    }


    @After
    public void destroy() {
        this.controller.destroy();
    }
}