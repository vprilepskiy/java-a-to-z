package ru.job4j.model.entity;

/**
 * Created by VLADIMIR on 26.01.2018.
 */
public class UserHasMusicType extends AbstractEntity {

    private final int userId;

    private final int musicTypeId;

    public UserHasMusicType(int id, int userId, int musicTypeId) {
        this.id = id;
        this.userId = userId;
        this.musicTypeId = musicTypeId;
    }

    public UserHasMusicType(int userId, int musicTypeId) {
        this.userId = userId;
        this.musicTypeId = musicTypeId;
    }

    public int getUserId() {
        return userId;
    }

    public int getMusicTypeId() {
        return musicTypeId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserHasMusicType that = (UserHasMusicType) o;

        if (id != that.id) return false;
        if (userId != that.userId) return false;
        return musicTypeId == that.musicTypeId;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + userId;
        result = 31 * result + musicTypeId;
        return result;
    }

    @Override
    public String toString() {
        return "UserHasMusicType{" +
                "id=" + id +
                ", userId=" + userId +
                ", musicTypeId=" + musicTypeId +
                '}';
    }
}
