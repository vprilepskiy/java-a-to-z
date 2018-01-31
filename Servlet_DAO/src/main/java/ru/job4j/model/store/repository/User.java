package ru.job4j.model.store.repository;

import ru.job4j.model.entity.Address;
import ru.job4j.model.entity.MusicType;
import ru.job4j.model.entity.Role;
import ru.job4j.model.entity.UserHasMusicType;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by VLADIMIR on 30.01.2018.
 */
public class User extends AbstractUser {

    public User() {
    }

    public User(ru.job4j.model.entity.Role role, Address address, Set<MusicType> musicTypes, ru.job4j.model.entity.User user) {
        this.role = role;
        this.address = address;
        this.musicTypes = musicTypes;
        this.user = user;
    }


    @Override
    public void read() {
        this.role = this.daoRole.readById(this.user.getRoleId());
        this.address = this.findAddressByUserId(this.user.getId());
        this.musicTypes = this.findMusicTypesByUserId(this.user.getId());
    }


    @Override
    public void create() {
        if (this.role == null) {
            throw new NullPointerException("Role is not set");
        }
        if (this.address == null) {
            throw new NullPointerException("Address is not set");
        }
        if (this.musicTypes == null) {
            throw new NullPointerException("MusicTypes is not set");
        }
        if (this.user == null) {
            throw new NullPointerException("User is not set");
        }

        // бобавить в БД роль
        this.daoRole.create(this.role);
        // в юзера записать ид_роль
        this.user.setRoleId(this.role.getId());
        // бобавить в БД юзера
        this.daoUser.create(this.user);
        // в адрес записать ид_юзера
        this.address.setUserId(this.user.getId());
        // бобавить в БД адрес
        this.daoAddress.create(this.address);

        for (MusicType musicType : this.musicTypes) {
            // бобавить в БД musicType
            this.daoMusicType.create(musicType);
            // бобавить в БД userHasMusicType
            this.daoUserHasMusicType.create(new UserHasMusicType(this.user.getId(), musicType.getId()));
        }
    }

    @Override
    public void find() {
        if ((this.role == null) && (this.address == null) && (this.musicTypes == null)) {
            throw new NullPointerException("Search options is not set");
        }

        this.users = new HashSet<>();

        // поиск по role
        if (this.role != null){
            this.users.addAll(this.findUsersByRoleId(this.role.getId()));
        }
        // поиск по address
        if (this.address != null) {
            this.users.add(this.findUsersByAddress(this.address.getId()));
        }
        // поиск по musicTypes
        if (this.musicTypes != null) {
            for (MusicType musicType : this.musicTypes) {
                this.users.addAll(this.findUsersByMusicType(musicType.getId()));
            }
        }
    }


    /**
     * Find Address by user_id.
     * @param userId
     * @return
     */
    private Address findAddressByUserId(int userId) {
        ru.job4j.model.entity.Address result = null;

        for (ru.job4j.model.entity.Address address : this.daoAddress.read()) {
            if (address.getUserId() == userId) {
                result = address;
                break;
            }
        }

        return result;
    }


    /**
     * Find music types by user_id.
     * @param userId
     * @return
     */
    private Set<MusicType> findMusicTypesByUserId(int userId) {
        final Set<ru.job4j.model.entity.MusicType> result = new HashSet<>();

        for (ru.job4j.model.entity.UserHasMusicType userHasMusicType : this.daoUserHasMusicType.read()) {
            if (userHasMusicType.getUserId() == userId) {
                int musicTypeId = userHasMusicType.getMusicTypeId();
                result.add(this.daoMusicType.readById(musicTypeId));
            }
        }

        return result;
    }


    /**
     * Find Users by role_id.
     * @param roleId
     * @return
     */
    private Set<ru.job4j.model.entity.User> findUsersByRoleId(int roleId) {
        final Set<ru.job4j.model.entity.User> result = new HashSet<>();

        for (ru.job4j.model.entity.User user : this.daoUser.read()) {
            if (user.getRoleId() == roleId) {
                result.add(user);
            }
        }

        return result;
    }


    /**
     * Find Users by music_type_id.
     * @param musicTypeId
     * @return
     */
    private Set<ru.job4j.model.entity.User> findUsersByMusicType(int musicTypeId) {
        final Set<ru.job4j.model.entity.User> result = new HashSet<>();
        for (UserHasMusicType userHasMusicType : this.daoUserHasMusicType.read()) {
            if (userHasMusicType.getMusicTypeId() == musicTypeId) {
                int userId = userHasMusicType.getUserId();
                result.add(this.daoUser.readById(userId));
            }
        }

        return result;
    }


    /**
     * Find Users by address_id.
     * @param addressId
     * @return
     */
    private ru.job4j.model.entity.User findUsersByAddress(int addressId) {
        int userId = this.daoAddress.readById(addressId).getUserId();
        return this.daoUser.readById(userId);
    }
}
