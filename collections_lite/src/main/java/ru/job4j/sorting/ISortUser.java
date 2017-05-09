package ru.job4j.sorting;

import java.util.List;
import java.util.Set;

/**
 * Created by VLADIMIR on 08.05.2017.
 */
public interface ISortUser {

    /**
     * Отсортированных пользователей по возрасту, в порядке возрастания.
     * @param userList - список пользователей.
     * @return - отсортированный список пользователей.
     */
    Set<User> sort(List<User> userList);

    /**
     * Отсортирует List<User> по hash-коду.
     * @param userList - список пользователей.
     * @return - отсортированный список пользователей.
     */
    List<User> sortHash (List<User> userList);

    /**
     * Отсортирует List<User> по длине имени.
     * @param userList - список пользователей.
     * @return - отсортированный список пользователей.
     */
    List<User> sortLength (List<User> userList);

}
