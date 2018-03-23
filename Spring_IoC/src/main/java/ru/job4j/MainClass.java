package ru.job4j;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by VLADIMIR on 23.03.2018.
 */
public class MainClass {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");

        UserStorage userStorage = context.getBean(UserStorage.class);
        userStorage.add(new User());
    }
}
