package ru.job4j.model.store.dao;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import ru.job4j.model.store.DataBase;
import ru.job4j.model.store.Settings;

/**
 * Created by VLADIMIR on 29.01.2018.
 */
@Ignore
public class daoTest {

    private final MusicTypeTest musicTypeTest = new MusicTypeTest();

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

    @Test
    public void musicTypeTest() throws Exception {
        this.musicTypeTest.create();
        this.musicTypeTest.read();
        this.musicTypeTest.readById();
        this.musicTypeTest.update();
        this.musicTypeTest.delete();
    }

    @After
    public void dbCloseConnect() {
        DataBase.getInstance().closeConnection();
    }

}
