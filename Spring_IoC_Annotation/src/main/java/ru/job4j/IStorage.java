package ru.job4j;

import org.springframework.stereotype.Component;

/**
 * Created by VLADIMIR on 19.02.2018.
 */
@Component
public interface IStorage {

    void add(User user);

}
