package ru.job4j.sorting;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by VLADIMIR on 08.05.2017.
 */
public class SortUserTest {

    @Test
    public void main() {

        User user0 = new User("Uasya", 22);
        User user1 = new User("Fedor", 44);
        User user2 = new User("Alex", 33);


        final Set<User> set = new TreeSet<User>();
        set.addAll(Arrays.asList(user0, user1, user2));

        for (User user : set) {
            System.out.println(user);
        }
    }

}
