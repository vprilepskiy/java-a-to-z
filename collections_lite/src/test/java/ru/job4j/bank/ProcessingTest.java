package ru.job4j.bank;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;


/**
 * Created by VLADIMIR on 11.05.2017.
 */
public class ProcessingTest {

    /**
     * Процессинг.
     */
    private Processing processing = new Processing();

    /**
     * Предварительные настройки.
     */
    @Before
    public void before() {
        final User user0 = new User("user0", 0);
        final User user1 = new User("user1", 1);

        final Account account0 = new Account(100, 111);
        final Account account1 = new Account(200, 222);
        final Account account2 = new Account(300, 333);

        this.processing.addUser(user0);
        this.processing.addUser(user1);

        this.processing.addAccountToUser(user0, account0);
        this.processing.addAccountToUser(user0, account1);
        this.processing.addAccountToUser(user1, account2);
    }

    /**
     * Test.
     */
    @Test
    public void whenTransferMoneyForSingleUser() {

        final User user0 = new User(0);
        final Account account0 = new Account(111);
        final Account account1 = new Account(222);

        final double amount = 50;
        final double result0 = 50;
        final double result1 = 250;

        boolean trzOk = this.processing.transferMoney(user0, account0, user0, account1, amount);

        List<Account> accounts = this.processing.getUserAccounts(user0);

        Assert.assertThat(true, Is.is(trzOk));
        Assert.assertThat(result0, Is.is(accounts.get(0).getValue()));
        Assert.assertThat(result1, Is.is(accounts.get(1).getValue()));
    }

    /**
     * Test.
     */
    @Test
    public void whenTransferMoneyForDifferentUser() {

        final User user0 = new User(0);
        final User user1 = new User(1);

        final Account account0 = new Account(111);
        final Account account1 = new Account(333);

        final double amount = 50;
        final double result0 = 50;
        final double result1 = 350;

        boolean trzOk = this.processing.transferMoney(user0, account0, user1, account1, amount);

        List<Account> accounts0 = this.processing.getUserAccounts(user0);
        List<Account> accounts1 = this.processing.getUserAccounts(user1);

        Assert.assertThat(true, Is.is(trzOk));
        Assert.assertThat(result0, Is.is(accounts0.get(0).getValue()));
        Assert.assertThat(result1, Is.is(accounts1.get(0).getValue()));
    }

    /**
     * Test.
     */
    @Test
    public void whenTransferMoneyFailed() {
        final User user0 = new User(0);
        final Account account0 = new Account(111);
        final Account account1 = new Account(222);

        final double amount = 101;
        final double result0 = 100;
        final double result1 = 200;

        boolean trzOk = this.processing.transferMoney(user0, account0, user0, account1, amount);

        List<Account> accounts = this.processing.getUserAccounts(user0);

        Assert.assertThat(false, Is.is(trzOk));
        Assert.assertThat(result0, Is.is(accounts.get(0).getValue()));
        Assert.assertThat(result1, Is.is(accounts.get(1).getValue()));
    }

}
