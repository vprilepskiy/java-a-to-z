package ru.job4j.map.users;

import org.junit.Test;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by VLADIMIR on 26.06.2017.
 */
public class TestUser {

    /**
     * Print to console.
     */
    @Test
    public void printMap() {

        final Map<User, Object> map = new HashMap<User, Object>();
        map.put(new User("Alex", 0, new GregorianCalendar(2010, 02, 21)), "test1");
        map.put(new User("Alex", 0, new GregorianCalendar(2010, 02, 21)), "test2");

        for (Map.Entry<User, Object> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "; " + entry.getValue());
        }

    }

}
