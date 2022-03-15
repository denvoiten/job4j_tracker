package ru.job4j.search;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> compareName = s -> s.getName().contains(key);
        Predicate<Person> compareSurName = s -> s.getSurname().contains(key);
        Predicate<Person> comparePhone = s -> s.getPhone().contains(key);
        Predicate<Person> compareAddress = s -> s.getAddress().contains(key);
        Predicate<Person> combine = compareName.or(compareSurName.or(comparePhone.or(compareAddress)));
        var result = new ArrayList<Person>();
        for (var person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
