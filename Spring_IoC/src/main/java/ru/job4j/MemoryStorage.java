package ru.job4j;


import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by VLADIMIR on 19.02.2018.
 */
@Component
public class MemoryStorage implements IStorage {

    private final Set<User> users = new HashSet<>();
    private int sequence = 1;

    @Override
    public void add(User user) {

        if (user.getId() != 0) {
            throw new IllegalArgumentException("user.getId() != 0");
        }

        user.setId(this.sequence++);
        if (users.add(user)) {
            System.out.println("store to memory");
        } else {
            throw new IllegalArgumentException("already contains the object to add");
        }
    }

}
