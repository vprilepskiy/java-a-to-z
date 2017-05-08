package ru.job4j.sorting;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by VLADIMIR on 08.05.2017.
 */
public class SortUser implements ISortUser {

    @Override
    public Set<User> sort(List<User> userList) {

        Set<User> set = new TreeSet<User>();

        set.addAll(userList);

        return set;
    }

}
