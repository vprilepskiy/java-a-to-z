package ru.job4j.transformation;

import java.util.HashMap;
import java.util.List;

/**
 * Created by VLADIMIR on 06.05.2017.
 */
public class UserConvert implements IUserConvert {

    @Override
    public HashMap<Integer, User> process(List<User> list) {

        HashMap<Integer, User> map = new HashMap<Integer, User>();

        for (User user : list) {
            map.put(user.getId(), user);
        }

        return map;
    }
}
