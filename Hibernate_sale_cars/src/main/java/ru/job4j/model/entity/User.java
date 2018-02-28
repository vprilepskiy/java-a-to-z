package ru.job4j.model.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by VLADIMIR on 26.02.2018.
 */
public class User {

    private int id;

    private String login;

    private String password;

    Set<Item> items = new HashSet<>();

}
