package ru.job4j.model.store.dao;

import org.hamcrest.core.Is;
import org.junit.*;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by VLADIMIR on 29.01.2018.
 */
public class MusicTypeTest {

    /**
     * Entity.
     */
    private final ru.job4j.model.entity.MusicType entityMusicType = new ru.job4j.model.entity.MusicType("testMusicType3");


    public int create() throws Exception {
        new MusicType().create(this.entityMusicType);
        Assert.assertTrue(this.entityMusicType.getId() != -1);
        return this.entityMusicType.getId();
    }


    public void read() throws Exception {
        List<ru.job4j.model.entity.MusicType> musicTypes = new MusicType().read();
        Assert.assertFalse(musicTypes.isEmpty());
    }


    public void readById() throws Exception {
        ru.job4j.model.entity.MusicType musicType = new MusicType().readById(this.entityMusicType.getId());
        Assert.assertThat(musicType, Is.is(this.entityMusicType));
    }


    public void update() throws Exception {
        final boolean result = new MusicType().update(new ru.job4j.model.entity.MusicType(this.entityMusicType.getId(),"testMusicTypeUpdate"));
        Assert.assertTrue(result);
    }


    public void delete() throws Exception {
        final boolean result = new MusicType().delete(this.entityMusicType.getId());
        Assert.assertTrue(result);
    }

}