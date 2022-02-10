package ru.job4j.search;

import java.util.ArrayList;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        ArrayList<Person> rsl = new ArrayList<>();
        for (Person value : persons) {
            if (value.getName().contains(key)
                    || value.getPhone().contains(key)
                    || value.getAddress().contains(key)
                    || value.getSurname().contains(key)) {
                rsl.add(value);
            }
        }
        return rsl;
    }
}
