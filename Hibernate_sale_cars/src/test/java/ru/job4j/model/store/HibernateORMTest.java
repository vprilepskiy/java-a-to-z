package ru.job4j.model.store;

import org.hamcrest.core.Is;
import org.junit.*;
import ru.job4j.model.entity.Item;
import ru.job4j.model.entity.User;

/**
 * Created by VLADIMIR on 05.03.2018.
 */
public class HibernateORMTest {
    @Before
    public void setUp() throws Exception {
        HibernateORM.getInstance().setUp();
    }


    @Test
    public void testAllMethods() {
        final String login = "testLogin";
        final String password = "testPassword";

        HibernateORM.getInstance().addUser(login, password);
        final User user = HibernateORM.getInstance().getUserByLoginPass(login, password);

        Assert.assertThat(login, Is.is(user.getLogin()));
        Assert.assertThat(password, Is.is(user.getPassword()));

        HibernateORM.getInstance().addItem(user, 0, 0, 0, 0, 0);
        for (Item item : HibernateORM.getInstance().getItems(user)) {
            Assert.assertThat(item.getId(), Is.is(1));
            Assert.assertTrue(item.isActive());
            Assert.assertNull(item.getPhoto());
            break;
        }

        Item photo = new Item();
        photo.setId(1);
        photo.setPhoto(new byte[]{0, 1, 2});

        HibernateORM.getInstance().updatePhoto(photo);
        HibernateORM.getInstance().setActive(1, false);

        for (Item item : HibernateORM.getInstance().getItems(user)) {
            Assert.assertThat(item.getId(), Is.is(1));
            Assert.assertFalse(item.isActive());
            Assert.assertThat(item.getPhoto(), Is.is(new byte[]{0, 1, 2}));
            break;
        }
    }


    @After
    public void tearDown() throws Exception {
        HibernateORM.getInstance().close();
    }


}