package ru.job4j.bank;

import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by VLADIMIR on 11.05.2017.
 */
public class ProcessingTest {

    @Test
    public void whenAddUser(){

        User user0 = new User("user0", 0);
        User user1 = new User("user1", 1);

        Processing processing = new Processing();
        processing.addUser(user0);
        processing.addUser(user1);

        processing.addAccountToUser(user0, new Account(100, 111));
        processing.addAccountToUser(user0, new Account(200, 222));

        processing.transferMoney(user0, new Account(0, 111), user0, new Account(0, 222), 50);

//        processing.deleteUser(new User("user1", 1));

        for (Map.Entry<User, List<Account>> listEntry : processing.users.entrySet()) {
            System.out.print("UserName: " + listEntry.getKey().getName());
            System.out.println("; Passport: " + listEntry.getKey().getPassport());

            List<Account> accountList = listEntry.getValue();
            if (accountList != null) {
                for (Account account : accountList){
                    System.out.print("\t");
                    System.out.print("Summa: " + account.getValue());
                    System.out.println("Requisites: " + account.getRequisites());
                }
            }
        }

//        for (User user : processing.users.keySet()){
//            System.out.println(user.toString());
//        }



    }


}
