package ru.job4j.generic.store;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by VLADIMIR on 31.05.2017.
 */
public class UserStoreTest {

    /**
     * ATest add and get.
     */
    @Test
    public void whenAddUserInUserStoreWhenGetUser() {
        final int size = 1;
        final UserStore userStore = new UserStore(size);

        userStore.add(new User("idUser0"));

        Assert.assertThat(userStore.get(0), Is.is(new User("idUser0")));
    }

    /**
     * ATest update.
     */
    @Test
    public void whenAddUserAndUpdate() {
        final int size = 1;
        final UserStore userStore = new UserStore(size);

        userStore.add(new User("idUser0"));
        userStore.update(0, new User("updateIdUser"));

        Assert.assertThat(userStore.get(0), Is.is(new User("updateIdUser")));
    }

    /**
     * ATest delete.
     */
    @Test
    public void whenAddUserAndDelete() {
        final int size = 1;
        final UserStore userStore = new UserStore(size);

        userStore.add(new User("idUser0"));
        userStore.delete(0);

        Assert.assertNull(userStore.get(0));
    }
}
