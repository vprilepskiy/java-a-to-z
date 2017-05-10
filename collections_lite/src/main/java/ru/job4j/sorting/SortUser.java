package ru.job4j.sorting;

import java.util.Comparator;
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

    @Override
    public List<User> sortHash(List<User> userList) {

        userList.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return Integer.compare(o1.hashCode(), o2.hashCode());
            }
        });

        return userList;
    }

    @Override
    public List<User> sortLength(List<User> userList) {
        userList.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return Integer.compare(o1.getName().length(), o2.getName().length());
            }
        });
        return userList;
    }

}
