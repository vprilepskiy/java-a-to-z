package ru.job4j.transformation;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by VLADIMIR on 06.05.2017.
 */
public class UserConvertTest {

    /**
     * Test.
     */
    @Test
    public void whenSetListUserThenGetMapUser() {

        User user0 = new User(0, "Uasya", "Chelyabinsk");
        User user1 = new User(1, "Fedor", "Yekaterinburg");
        User user2 = new User(2, "Genadiy", "Tumen");

        List<User> list = new ArrayList<User>();
        list.add(user0);
        list.add(user1);
        list.add(user2);

        HashMap<Integer, User> map = new HashMap<Integer, User>();
        map.put(0, user0);
        map.put(1, user1);
        map.put(2, user2);

        UserConvert userConvert = new UserConvert();

        Assert.assertThat(map, Is.is(userConvert.process(list)));
    }
}
