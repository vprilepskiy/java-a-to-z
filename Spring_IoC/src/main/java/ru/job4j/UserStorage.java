package ru.job4j;


import org.springframework.context.annotation.Bean;

/**
 * Created by VLADIMIR on 19.02.2018.
 */
public class UserStorage {

    /**
     * iStorage.
     */
    private final IStorage iStorage;


    /**
     * Constructor.
     * @param iStorage - iStorage.
     */
    public UserStorage(IStorage iStorage) {
        this.iStorage = iStorage;
    }


    /**
     * Add user.
     * @param user - user.
     */
    public void add(User user) {
        this.iStorage.add(user);
    }
}
