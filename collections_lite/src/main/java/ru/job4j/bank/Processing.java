package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by VLADIMIR on 11.05.2017.
 */
public class Processing implements IProcessing {

    /**
     * Пользователи со счетами.
     */
    private Map<User, List<Account>> users = new HashMap<>();

    @Override
    public void addUser(User user) {
        this.users.put(user, new ArrayList<Account>());
    }

    @Override
    public void deleteUser(User user) {
        this.users.remove(user);
    }

    @Override
    public void addAccountToUser(User user, Account account) {
        List<Account> accountList = this.users.get(user);
        accountList.add(account);
    }

    @Override
    public void deleteAccountFromUser(User user, Account account) {
        List<Account> accountList = this.users.get(user);
        accountList.remove(user);
    }

    @Override
    public List<Account> getUserAccounts(User user) {
        return this.users.get(user);
    }

    @Override
    public boolean transferMoney(User srcUser, Account srcAccount, User dstUser, Account dstAccount, double amount) {

        boolean result = false;

        Account debitAccount = this.getValidAccount(srcUser, srcAccount, -1 * amount);
        Account creditAccount = this.getValidAccount(dstUser, dstAccount, amount);

        if ((debitAccount != null) && (creditAccount != null)) {
            debitAccount.setValue(debitAccount.getValue() - amount);
            creditAccount.setValue(creditAccount.getValue() + amount);
            result = true;
        }

        return result;
    }

    /**
     * Проверит состояние счета.
     * @param user - Пользователь.
     * @param account - Счет пользователя.
     * @param amount - Сумма. Если списание, то положительная. Если пополнение, то отрицательная.
     * @return - Счет пользователя. Null если не найден или операция списания больше чем остаток.
     */
    private Account getValidAccount(User user, Account account, double amount) {

        Account result = null;
        List<Account> accountList = this.users.get(user);

        for (Account acc : accountList) {
            if (acc.equals(account)) {
                if ((acc.getValue() + amount) >= 0) {
                    result = acc;
                }
                break;
            }
        }
        return result;
    }
}
