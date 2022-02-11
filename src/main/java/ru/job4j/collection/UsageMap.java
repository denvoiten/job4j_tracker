package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("name@gmail.com", "Popov Ivan Ivanovich");
        map.put("name1@gmail.com", "Sergeev Sergey Sergeevich");
        map.put("name2@gmail.com", "Ivanov Petr Andreevich");
        for (String key : map.keySet()) {
            String value = map.get(key);
            System.out.println(key + " = " + value);
        }
    }
}
