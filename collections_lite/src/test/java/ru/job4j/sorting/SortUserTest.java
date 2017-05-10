package ru.job4j.sorting;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;


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

        List<User> sortList = new SortUser().sortHash(userList);

        Iterator itResult = result.values().iterator();
        Iterator itSortList = sortList.iterator();

        while (itResult.hasNext() && itSortList.hasNext()) {
            Assert.assertThat(itResult.next(), Is.is(itSortList.next()));
        }
    }

    /**
     * Test sort by NameLength.
     */
    @Test
    public void whenSortingByNameLength() {

        final User user0 = new User("Gosha", 15);
        final User user1 = new User("Vladimir", 55);
        final User user2 = new User("Alexey", 35);

        final List<User> userList = Arrays.asList(user0, user1, user2);
        final List<User> result = Arrays.asList(user0, user2, user1);

        List<User> sortList = new SortUser().sortLength(userList);

        Iterator itResult = result.iterator();
        Iterator itSortList = sortList.iterator();

        while (itResult.hasNext() && itSortList.hasNext()) {
            Assert.assertThat(itResult.next(), Is.is(itSortList.next()));
        }
    }
}
