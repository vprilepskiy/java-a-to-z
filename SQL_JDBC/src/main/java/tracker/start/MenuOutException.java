package tracker.start;

/**
 * Собственный Exception наследованный от RuntimeException.
 * @author Vladimir Prilepskiy
 * @version 1
 * @since 27.12.2016
 */
public class MenuOutException extends RuntimeException {

    /**
     * Вернет классу родителю переданное сообщение.
     * @param msg - сообщение.
     */
    public MenuOutException(String msg) {
        super(msg);
    }
}
