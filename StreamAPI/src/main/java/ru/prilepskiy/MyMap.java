package ru.prilepskiy;

import java.util.HashMap;
import java.util.Map;

public class MyMap {
    public static void main(String[] args) {
        Map<String, Boolean> map = new HashMap<>();

        map.merge("1", Boolean.FALSE, (v1, v2) -> v1 || v2);
        map.merge("1", Boolean.FALSE, (v1, v2) -> v1 || v2);
        map.merge("2", Boolean.FALSE, (v1, v2) -> v1 || v2);
        map.merge("2", Boolean.TRUE, (v1, v2) -> v1 || v2);
        map.merge("2", Boolean.FALSE, (v1, v2) -> v1 || v2);

        System.out.println(map);
    }
}
