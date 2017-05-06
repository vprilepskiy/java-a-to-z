package ru.job4j.transformation;

import java.util.HashMap;
import java.util.List;

/**
 * Created by VLADIMIR on 06.05.2017.
 * Написать программу преобразования List в Map. [#14421].
 */
public interface IUserConvert {

    /**
     * Конвертирует пользователей в Map с ключом Integer id и соответствующим ему User.
     * @param list - список пользователей.
     * @return - карта пользователей.
     */
    HashMap<Integer, User> process(List<User> list);

}
