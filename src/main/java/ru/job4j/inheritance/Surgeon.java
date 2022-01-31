package ru.job4j.inheritance;

public class Surgeon extends Doctor {
    private int operations;

    public Surgeon(String name, String surname, String education, String birthday, boolean licensed, int operations) {
        super(name, surname, education, birthday, licensed);
        this.operations = operations;
    }

    public void operation(Patient patient) {

    }
}
