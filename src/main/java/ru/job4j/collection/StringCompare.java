package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int length = Math.min(left.length(), right.length());
        int check = 0;
        for (int i = 0; i < length; i++) {
            check = Character.compare(left.charAt(i), right.charAt(i));
            if (check != 0) {
                break;
            }
        }
        return check == 0 ? Integer.compare(left.length(), right.length()) : check;
    }
}
