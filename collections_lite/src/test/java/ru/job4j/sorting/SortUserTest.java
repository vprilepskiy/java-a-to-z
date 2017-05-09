package ru.job4j.sorting;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;


/**
 * Created by VLADIMIR on 08.05.2017.
 */
public class SortUserTest {

    /**
     * Test.
     */
    @Test
    public void test() {

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
}
