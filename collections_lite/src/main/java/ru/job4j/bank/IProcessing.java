package ru.job4j.bank;

import java.util.List;

/**
 * Created by VLADIMIR on 11.05.2017.
 */
public interface IProcessing {

    /**
     * добавление пользователя.
     * @param user - пользователь.
     */
    void addUser(User user);

    /**
     * удаление пользователя.
     * @param user - пользователь.
     */
    void deleteUser(User user);

    /**
     * добавить счёт пользователю.
     * @param user - пользователь.
     * @param account - банковский счет.
     */
    void addAccountToUser(User user, Account account);

    /**
     * удалить один счёт пользователя.
     * @param user - пользователь.
     * @param account - банковский счет.
     */
    void deleteAccountFromUser(User user, Account account);

    /**
     * получить список счетов для пользователя.
     * @param user - пользователь.
     * @return - банковские счета.
     */
    List<Account> getUserAccounts(User user);

    /**
     * метод для перечисления денег с одного счёта на другой счёт:
     * если счёт не найден или не хватает денег на счёте srcAccount (с которого переводят) должен вернуть false.
     * @param srcUser - пользователь с кого.
     * @param srcAccount - банковский счет.
     * @param dstUser - пользователь на кого.
     * @param dstAccount - банковский счет.
     * @param amount - сумма.
     * @return - true если операция успешна. False если операция не успешна.
     */
    boolean transferMoney(User srcUser, Account srcAccount, User dstUser, Account dstAccount, double amount);

}
