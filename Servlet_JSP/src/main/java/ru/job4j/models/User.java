package ru.job4j.models;

/**
 * Created by VLADIMIR on 22.11.2017.
 */
public class User {

    /**
     * Name.
     */
    private final String name;
    /**
     * Login.
     */
    private final String login;
    /**
     * Email.
     */
    private final String email;
    /**
     * Create date.
     */
    private final String createDate;

    /**
     * Constructor.
     * @param name - name.
     * @param login - login.
     * @param email - email.
     * @param createDate - create date.
     */
    public User(String name, String login, String email, String createDate) {
        this.name = name;
        this.login = login;
        this.email = email;
        this.createDate = createDate;
    }

    /**
     * Constructor.
     * @param name - name.
     * @param login - login.
     * @param email - email.
     */
    public User(String name, String login, String email) {
        this.name = name;
        this.login = login;
        this.email = email;
        this.createDate = "";
    }

    /**
     * Constructor.
     * @param name - name.
     */
    public User(String name) {
        this.name = name;
        this.login = "";
        this.email = "";
        this.createDate = "";
    }

    /**
     * Get name.
     * @return - name.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Get login.
     * @return - login.
     */
    public String getLogin() {
        return this.login;
    }

    /**
     * Get. email.
     * @return - email.
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * Get create date.
     * @return - create date.
     */
    public String getCreateDate() {
        return this.createDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        User user = (User) o;

        return name != null ? name.equals(user.name) : user.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("User_name='").append(this.name);
        sb.append("', Login='").append(this.login);
        sb.append("', Email='").append(this.email);
        sb.append("', Create_date='").append(this.createDate);
        sb.append("';");

        return sb.toString();
    }
}
