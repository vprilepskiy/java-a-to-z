package ru.job4j.model.entity;


/**
 * Created by VLADIMIR on 26.01.2018.
 */
public class MusicType extends AbstractEntity {

    private final String name;

    public MusicType(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public MusicType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MusicType musicType = (MusicType) o;

        if (id != musicType.id) return false;
        return name != null ? name.equals(musicType.name) : musicType.name == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "MusicType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
