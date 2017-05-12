package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by VLADIMIR on 11.05.2017.
 */
public class Processing implements IProcessing {

    public Map<User, List<Account>> users = new HashMap<>();



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

        List<Account> accountList = this.users.get(srcUser);

        boolean foundDebitAccount = false;
        boolean foundCreditAccount = false;

        Account debitAccount = null;
        Account creditAccount = null;

        for(Account account : accountList){
            // дебет
            if (account.equals(srcAccount)){
                if ((account.getValue() - amount) >= 0){
                    debitAccount = account;
                }
                foundDebitAccount = true;
            }
            // кредит
            if (account.equals(dstAccount)){
                if ((account.getValue() + amount) >= 0){
                    creditAccount = account;
                }
                foundCreditAccount = true;
            }
            // если srcAccount и dstAccount найдены прекратить итерацию
            if (foundDebitAccount && foundCreditAccount){
                break;
            }
        }

        if ((debitAccount != null) && (creditAccount != null)) {
            debitAccount.setValue(debitAccount.getValue() - amount);
            creditAccount.setValue(creditAccount.getValue() + amount);
            result = true;
        }

        return result;
    }
}
