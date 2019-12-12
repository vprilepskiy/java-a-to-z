package ru.prilepskiy;

import java.util.HashMap;
import java.util.Map;

public class MyMap {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();

        map.put(2, "aaa");
        map.merge(1, "bbb", (oldValue, newValue) -> oldValue + newValue);
        map.merge(2, "ccc", (oldValue, newValue) -> oldValue + newValue);
        System.out.println(map);
    }
}
