package ru.job4j;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * Created by VLADIMIR on 19.02.2018.
 */
public class UserStorageTest {


    @Test
    public void whenLoadContextShouldGetBeansUserStorage() throws Exception {

        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");

        UserStorage userStorage = context.getBean(UserStorage.class);
        userStorage.add(new User());

        assertNotNull(userStorage);
    }
}