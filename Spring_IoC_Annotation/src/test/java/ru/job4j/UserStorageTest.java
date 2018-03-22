package ru.job4j;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * Created by VLADIMIR on 21.03.2018.
 */
public class UserStorageTest {


    @Test
    public void whenAddUserToStorageShouldSafeIt() throws Exception {
        UserStorage userStorage = null;

        userStorage = new UserStorage(new MemoryStorage());
        userStorage.add(new User());

        userStorage = new UserStorage(new JdbcStorage());
        userStorage.add(new User());
    }


    @Test
    public void whenLoadContextShouldGetBeansMemoryStorage() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");

        MemoryStorage memoryStorage = context.getBean(MemoryStorage.class);
        memoryStorage.add(new User());

        assertNotNull(memoryStorage);
    }


    @Test
    public void whenLoadContextShouldGetBeansUserStorage() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");

        UserStorage userStorage = context.getBean(UserStorage.class);
        userStorage.add(new User());

        assertNotNull(userStorage);
    }



    @Test
    public void whenLoadContextShouldGetBeansJdbcStorage() throws Exception {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");

        JdbcStorage jdbcStorage = context.getBean(JdbcStorage.class);
        jdbcStorage.add(new User());

        context.registerShutdownHook();

        assertNotNull(jdbcStorage);
    }
}