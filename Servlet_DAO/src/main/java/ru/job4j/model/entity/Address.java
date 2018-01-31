package ru.job4j.model.entity;

/**
 * Created by VLADIMIR on 26.01.2018.
 */
public class Address extends AbstractEntity {

    /**
     * Place.
     */
    private final String place;

    /**
     * User id.
     */
    private int userId = -1;

    /**
     * Constructor.
     * @param id - id.
     * @param place - place.
     * @param userId - user id.
     */
    public Address(int id, String place, int userId) {
        this.id = id;
        this.place = place;
        this.userId = userId;
    }

    /**
     * Constructor.
     * @param place - place.
     */
    public Address(String place) {
        this.place = place;
    }

    /**
     * Getter.
     * @return - place.
     */
    public String getPlace() {
        return place;
    }

    /**
     * Getter.
     * @return - user id.
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Setter.
     * @param userId - user id.
     */
    public void setUserId(int userId) {
        if (this.userId == -1) {
            this.userId = userId;
        } else {
            throw new IllegalArgumentException(String.format("The value can not be changed again. The current ID is: %d." , this.userId));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Address address = (Address) o;

        if (id != address.id) return false;
        if (userId != address.userId) return false;
        return place != null ? place.equals(address.place) : address.place == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (place != null ? place.hashCode() : 0);
        result = 31 * result + userId;
        return result;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", place='" + place + '\'' +
                ", userId=" + userId +
                '}';
    }
}
