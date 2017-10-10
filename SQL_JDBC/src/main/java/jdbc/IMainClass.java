package jdbc;

/**
 * Created by VLADIMIR on 10.10.2017.
 */
public interface IMainClass {

    /**
     * Set url.
     * @param url - url.
     */
    void setUrl(String url);

    /**
     * Set username.
     * @param username - username.
     */
    void setUsername(String username);

    /**
     * Set password.
     * @param password - password.
     */
    void setPassword(String password);

    /**
     * Set number.
     * @param number - number.
     */
    void setNumber(int number);

    /**
     * Run the program.
     * @throws MyException - Exception if no parameters are specified.
     */
    void run() throws MyException;

}
