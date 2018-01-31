package ru.job4j.model.store.repository;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.job4j.model.entity.Address;
import ru.job4j.model.entity.MusicType;
import ru.job4j.model.entity.Role;
import ru.job4j.model.store.DataBase;
import ru.job4j.model.store.Settings;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by VLADIMIR on 30.01.2018.
 */
public class UserTest {

    @Before
    public void dbSetConnect() {
        Settings settings = new Settings("storeTest.properties");

        String url = settings.getValue("db_url");
        String userName = settings.getValue("db_username");
        String password = settings.getValue("db_password");

        System.out.println(url);
        System.out.println(userName);
        System.out.println(password);

        DataBase.getInstance().setConnection(url, userName, password);
    }

//    @Test
//    public void create() throws Exception {
//        final Role role = new Role("role111");
//        final Address address = new Address("address111");
//        final List<MusicType> musicTypes = new LinkedList<>();
//        musicTypes.add(new MusicType("nusicType111"));
//        final ru.job4j.model.entity.User user = new ru.job4j.model.entity.User("name111", "login111", "password111", "email111");
//
//        User repositoryUser = new User(role, address, musicTypes, user);
//        repositoryUser.create();
//    }

//    @Test
//    public void read() throws Exception {
//        User repositoryUser = new User();
//        repositoryUser.setUser(new ru.job4j.model.entity.User(9, "", "", "", "", 9));
//        repositoryUser.read();
//        System.out.println(repositoryUser.getRole());
//        System.out.println(repositoryUser.getAddress());
//        System.out.println(repositoryUser.getMusicTypes());
//    }

    @Test
    public void find() throws Exception {
        User repositoryUser = new User();
        repositoryUser.setRole(new Role(9, ""));
        repositoryUser.find();


        System.out.println(repositoryUser.getUsers());
    }

    @After
    public void dbCloseConnect() {
        DataBase.getInstance().closeConnection();
    }

}