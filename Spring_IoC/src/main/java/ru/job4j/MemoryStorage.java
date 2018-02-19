package ru.job4j;

/**
 * Created by VLADIMIR on 19.02.2018.
 */
public class MemoryStorage implements IStorage {

    @Override
    public void add(User user) {
        System.out.println("store to memory");
    }
}
