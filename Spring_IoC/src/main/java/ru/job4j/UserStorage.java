package ru.job4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by VLADIMIR on 19.02.2018.
 */
@Component
public class UserStorage {

    /**
     * iStorage.
     */
    private final IStorage iStorage;

    /**
     * Constructor.
     * @param iStorage - iStorage.
     */
    @Autowired
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
