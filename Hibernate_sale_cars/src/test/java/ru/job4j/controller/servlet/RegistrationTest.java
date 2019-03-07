package ru.job4j.controller.servlet;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.job4j.model.entity.User;
import ru.job4j.model.store.HibernateORM;

import static org.junit.Assert.*;

/**
 * Created by VLADIMIR on 11.03.2018.
 */
public class RegistrationTest {
    @Before
    public void setUp() throws Exception {
        HibernateORM.getInstance().setUp();
    }


    @Test
    public void registration() throws Exception {

        System.out.println("aaaaaa");
    }


    @After
    public void tearDown() throws Exception {
        HibernateORM.getInstance().close();
    }

}