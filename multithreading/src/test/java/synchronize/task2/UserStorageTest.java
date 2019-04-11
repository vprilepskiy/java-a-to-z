package synchronize.task2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import synchronize.task2.User;
import synchronize.task2.UserStorage;

public class UserStorageTest {

    private final UserStorage users = new UserStorage();

    @Before
    public void setUp() throws Exception {
        this.users.add(new User(0, 150));
        this.users.add(new User(1, 200));
    }

    @Test
    public void transferOk() {
        Assert.assertTrue(this.users.transfer(0, 1, 50));
    }

    @Test
    public void transferFail() {
        Assert.assertFalse(this.users.transfer(0, 1, 200));
    }
}