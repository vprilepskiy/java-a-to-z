package ru.job4j.sorting;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;


/**
 * Created by VLADIMIR on 08.05.2017.
 */
public class SortUserTest {

    /**
     * Test sort by age.
     */
    @Test
    public void whenSortingByAge() {

        final User user0 = new User("Uasya", 15);
        final User user1 = new User("Fedor", 50);
        final User user2 = new User("Alex", 30);

        final List<User> userList = Arrays.asList(user0, user1, user2);
        final List<User> result = Arrays.asList(user0, user2, user1);
        final Set<User> set = new SortUser().sort(userList);

        Iterator itSet = set.iterator();
        Iterator itResult = result.iterator();

        while (itSet.hasNext() && itResult.hasNext()) {
            Assert.assertThat(itResult.next(), Is.is(itSet.next()));
        }
    }

    /**
     * Test sort by HashCode.
     */
    @Test
    public void whenSortingByHashCode() {

        final User user0 = new User("Uasya", 15);
        final User user1 = new User("Fedor", 50);
        final User user2 = new User("Alex", 30);

        final List<User> userList = Arrays.asList(user0, user1, user2);
        final TreeMap<Integer, User> result = new TreeMap<>();
        for (User user : userList) {
            result.put(user.hashCode(), user);
        }

        for (Integer i : result.keySet()) {
            System.out.println(i);
        }

    }
}
