package ru.job4j.map.users;

import org.junit.Test;

import java.util.Calendar;
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

        User user1 = new User("Alex", 0, new GregorianCalendar(2010, 02, 21));
        User user2 = new User("Alex", 0, new GregorianCalendar(2010, 02, 21));

        System.out.println(user1.equals(user2));

        final Map<User, Object> map = new HashMap<User, Object>();
        map.put(user1, "test1");
        map.put(user2, "test2");

        for (Map.Entry<User, Object> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "; " + entry.getValue());
        }
    }
}
