package ru.job4j.model.store.repository;

import ru.job4j.model.entity.*;

import java.util.Set;

/**
 * Created by VLADIMIR on 31.01.2018.
 */
public abstract class AbstractUser {

    ru.job4j.model.entity.Role role;
    Address address;
    Set<MusicType> musicTypes;
    ru.job4j.model.entity.User user;
    Set<ru.job4j.model.entity.User> users;

    final ru.job4j.model.store.dao.Role daoRole;
    final ru.job4j.model.store.dao.Address daoAddress;
    final ru.job4j.model.store.dao.MusicType daoMusicType;
    final ru.job4j.model.store.dao.UserHasMusicType daoUserHasMusicType;
    final ru.job4j.model.store.dao.User daoUser;

    public AbstractUser() {
        this.daoRole = new ru.job4j.model.store.dao.Role();
        this.daoAddress = new ru.job4j.model.store.dao.Address();
        this.daoMusicType = new ru.job4j.model.store.dao.MusicType();
        this.daoUserHasMusicType = new ru.job4j.model.store.dao.UserHasMusicType();
        this.daoUser = new ru.job4j.model.store.dao.User();
    }

    public ru.job4j.model.entity.Role getRole() {
        return this.role;
    }

    public void setRole(ru.job4j.model.entity.Role role) {
        this.role = role;
    }

    public Address getAddress() {
        return this.address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<MusicType> getMusicTypes() {
        return this.musicTypes;
    }

    public void setMusicTypes(Set<MusicType> musicTypes) {
        this.musicTypes = musicTypes;
    }

    public ru.job4j.model.entity.User getUser() {
        return this.user;
    }

    public void setUser(ru.job4j.model.entity.User user) {
        this.user = user;
    }

    public Set<ru.job4j.model.entity.User> getUsers() {
        return users;
    }

    /**
     * операция получения всех связанных с ним сущностей
     */
    public abstract void read();

    /**
     * операция добавления нового User и всех связанных с ним сущностей;
     */
    public abstract void create();

    /**
     * операция поиска User по заданному параметру (Address, Role, MusicType).
     */
    public abstract void find();

}
